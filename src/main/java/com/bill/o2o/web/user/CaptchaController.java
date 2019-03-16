package com.bill.o2o.web.user;

import com.bill.o2o.service.CaptchaService;
import com.bill.o2o.util.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

@Controller
@RequestMapping(value = "")
public class CaptchaController {

    @Autowired
    private CaptchaService captchaService;


    @GetMapping(value = "/imgs")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException{
        CaptchaUtil vc = new CaptchaUtil();
        BufferedImage bi = vc.getImage();
        String message = vc.getText();

        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        HttpSession session = request.getSession(true);
        session.removeAttribute("verCode");
        session.removeAttribute("codeTime");
        session.setAttribute("verCode",message.toLowerCase());
        session.setAttribute("codeTime",new Date());
       // System.out.println(session.getId());

        //返回之前 将sessionId 和 验证吗的内容都存进数据库
        int storeResult = captchaService.addSessionAndCaptcha(session.getId(),message.toLowerCase());

        if (storeResult==1||storeResult==2){
            OutputStream out = response.getOutputStream();
            CaptchaUtil.output(bi,out);
        }else{
            session.setAttribute("错误","申请验证码失败");
        }




    }

}
