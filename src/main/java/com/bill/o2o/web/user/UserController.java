package com.bill.o2o.web.user;

import com.bill.o2o.entity.User;
import com.bill.o2o.service.CaptchaService;
import com.bill.o2o.service.CookiesService;
import com.bill.o2o.service.MessageCodeService;
import com.bill.o2o.service.UserService;
import com.bill.o2o.util.CookiesUtil;
import com.bill.o2o.util.MessageCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "")
public class UserController {

    @Autowired
    private CaptchaService captchaService;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageCodeService messageCodeService;

    @Autowired
    private CookiesService cookiesService;

    @RequestMapping(value = "/login_pwd", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> loginPwd(
            String userName,
            String password,
            String captcha,
            HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
//        String userName = request.getParameter("userName");
//        String password = request.getParameter("password");
//        String captcha = request.getParameter("captcha");

        System.out.println("userName=" + userName + "\n" +
                "password=" + password + "\n" +
                "captcha=" + captcha + "\n");

        HttpSession session = request.getSession(true);
        System.out.println(session.getId());

        Map<String, Object> resultMap = new HashMap<>();

        //对比session和验证码是否正确
        int isCaptchaRight = captchaService.checkSessionAndCaptcha(session.getId(), captcha.toLowerCase());
        // System.out.println("isCaptchaRight="+isCaptchaRight+"\n");

        if (isCaptchaRight == 1) {
            //  验证码正确
            System.out.println("开始查询");
            User loginUser = userService.checkAndReturnUser(userName, password);
            System.out.println("结束查询");
            System.out.println("user=" + loginUser + "\n");

            if (loginUser != null) {


                String userCookieContent = URLEncoder.encode(CookiesUtil.md5(loginUser.getUserName(), MessageCodeUtil.createCode()), "UTF-8");
                String passwordCookieContent = URLEncoder.encode(CookiesUtil.md5(loginUser.getPassword(), MessageCodeUtil.createCode()), "UTF-8");
                Cookie userCookie = CookiesUtil.createCookie("USER_NAME", userCookieContent);
                Cookie passwordCookie = CookiesUtil.createCookie("USER_PASSWORD", passwordCookieContent);
                response.addCookie(userCookie);
                response.addCookie(passwordCookie);

                //将Cookies存入数据库
                cookiesService.addCookies(loginUser.getUserName(), userCookieContent, passwordCookieContent);

                //  用户名和密码正确
                resultMap.put("code", "0");
                resultMap.put("data", loginUser);
                return resultMap;


            } else {
                //  用户名或密码不正确
                resultMap.put("code", "1");
                resultMap.put("msg", "用户名或密码不正确");
                return resultMap;
            }


        } else {
            resultMap.put("code", "1");
            resultMap.put("msg", "验证码不正确");
            return resultMap;
        }
    }

    @RequestMapping(value = "/login_sms", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> loginSms(String phoneNumber, String messageCode, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("phoneNumber:" + phoneNumber + "\n" + "messageCode:" + messageCode);

        Map<String, Object> resultMap = new HashMap<>();

        //  查看手机号和验证码是否匹配
        int isMessageCodeRight = messageCodeService.checkPhoneNumberAndCode(phoneNumber, messageCode);
        if (isMessageCodeRight == 1) {
            //  手机号和验证码匹配

            //  查看该手机号是否注册过
            User loginUser = userService.getUserByPhoneNumber(phoneNumber);

            if (loginUser != null) {
                //  该手机号已经注册过，直接返回用户信息

                String userCookieContent = URLEncoder.encode(CookiesUtil.md5(loginUser.getUserName(), MessageCodeUtil.createCode()), "UTF-8");
                String passwordCookieContent = URLEncoder.encode(CookiesUtil.md5(loginUser.getPassword(), MessageCodeUtil.createCode()), "UTF-8");
                Cookie userCookie = CookiesUtil.createCookie("USER_NAME", userCookieContent);
                Cookie passwordCookie = CookiesUtil.createCookie("USER_PASSWORD", passwordCookieContent);
                response.addCookie(userCookie);
                response.addCookie(passwordCookie);

                //将Cookies存入数据库
                cookiesService.addCookies(loginUser.getUserName(), userCookieContent, passwordCookieContent);

                resultMap.put("code", "0");
                resultMap.put("data", loginUser);
                return resultMap;
            } else {
                //  该手机号没有注册过，自动注册
                loginUser = new User();
                loginUser.setPhone(phoneNumber);
                loginUser.setUserName("user_" + phoneNumber);

                int isAutoRegisterSuccess = userService.insertUser(loginUser);
                if (isAutoRegisterSuccess == 0) {
                    //  自动注册失败
                    resultMap.put("code", "1");
                    resultMap.put("msg", "该手机号未注册，且自动注册失败");
                    return resultMap;
                } else {
                    //  自动注册成功，返回新用户的信息


                    String userCookieContent = URLEncoder.encode(CookiesUtil.md5(loginUser.getUserName(), MessageCodeUtil.createCode()), "UTF-8");
                    String passwordCookieContent = URLEncoder.encode(CookiesUtil.md5(loginUser.getPassword(), MessageCodeUtil.createCode()), "UTF-8");
                    Cookie userCookie = CookiesUtil.createCookie("USER_NAME", userCookieContent);
                    Cookie passwordCookie = CookiesUtil.createCookie("USER_PASSWORD", passwordCookieContent);
                    response.addCookie(userCookie);
                    response.addCookie(passwordCookie);

                    //将Cookies存入数据库
                    cookiesService.addCookies(loginUser.getUserName(), userCookieContent, passwordCookieContent);


                    resultMap.put("code", "0");
                    resultMap.put("data", loginUser);
                    return resultMap;
                }
            }

        } else {
            //  手机号和验证码不匹配
            resultMap.put("code", "1");
            resultMap.put("msg", "验证码不正确");
            return resultMap;
        }

    }

    @RequestMapping(value = "/auto_login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> autoLogin(String userCookie, String passwordCookie) {
        Map<String, Object> resultMap = new HashMap<>();

        User loginUser = cookiesService.checkCookies(userCookie, passwordCookie);

        if (loginUser!=null){
            resultMap.put("code", "0");
            resultMap.put("data", loginUser);
            return resultMap;
        }else{
            resultMap.put("code", "1");
            resultMap.put("msg", "自动登陆失败");
            return resultMap;
        }
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> logout (String userName){
        Map<String,Object> resultMap = new HashMap<>();
       //去数据库中删除相关的Cookies
        int resultInt = cookiesService.deleteCookiesByUserName(userName);
        if (resultInt == 1){
            resultMap.put("code","0");
            resultMap.put("msg","success");
            return resultMap;
        }else {
            resultMap.put("code","1");
            resultMap.put("msg","failed");
            return resultMap;
        }
    }

}
