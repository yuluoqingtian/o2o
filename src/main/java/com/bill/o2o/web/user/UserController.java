package com.bill.o2o.web.user;

import com.bill.o2o.entity.User;
import com.bill.o2o.service.CaptchaService;
import com.bill.o2o.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "")
public class UserController {

    @Autowired
    private CaptchaService captchaService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login_pwd", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> loginPwd(
                                            String userName,
                                            String password,
                                            String captcha,
                                            HttpServletRequest request) {
        //获取参数
//        String userName = request.getParameter("userName");
//        String password = request.getParameter("password");
//        String captcha = request.getParameter("captcha");

        System.out.println("userName="+userName+"\n"+
                "password="+password+"\n"+
                "captcha="+captcha+"\n");

        HttpSession session = request.getSession(true);
        System.out.println(session.getId());

        Map<String, Object> resultMap = new HashMap<>();

        //对比session和验证码是否正确
        int isCaptchaRight = captchaService.checkSessionAndCaptcha(session.getId(), captcha.toLowerCase());
        System.out.println("isCaptchaRight="+isCaptchaRight+"\n");

        if (isCaptchaRight == 1) {
            //  验证码正确
            System.out.println("开始查询");
            User loginUser = userService.checkAndReturnUser(userName, password);
            System.out.println("结束查询");
            System.out.println("user="+loginUser+"\n");

            if (loginUser != null) {
                //  用户名和密码正确
                resultMap.put("code","0");
                resultMap.put("data",loginUser);
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

}
