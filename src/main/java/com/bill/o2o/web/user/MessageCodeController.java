package com.bill.o2o.web.user;

import com.bill.o2o.service.MessageCodeService;
import com.bill.o2o.util.MessageCodeUtil;
import com.bill.o2o.util.SendCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "")
public class MessageCodeController {

    @Autowired
    private MessageCodeService messageCodeService;

    @RequestMapping(value = "/sendcode",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> sendMessageCode(HttpServletRequest request){
        Map<String,Object> resultMap = new HashMap<>();
        String phoneNumber = request.getParameter("phoneNumber");
        String messageCode = MessageCodeUtil.createCode();

        //发送验证码
        int isSendSuccess = SendCodeUtil.sendCode(phoneNumber,messageCode);

        if (isSendSuccess==1){
            //  发送手机验证码成功
            // 将手机号和验证码存入数据库
            int isSaveSuccess = messageCodeService.savePhoneNumberAndCode(phoneNumber,messageCode);
            if (isSaveSuccess==1||isSaveSuccess==2){
                //  储存验证码成功
                resultMap.put("code","0");
                return resultMap;

            }else{
                //  储存验证码失败
                resultMap.put("code","1");
                resultMap.put("msg","储存验证码失败");
                return resultMap;

            }

        }else {
            //  发送验证码失败
            resultMap.put("code","1");
            resultMap.put("msg","发送验证码失败");
            return resultMap;
        }


    }
}
