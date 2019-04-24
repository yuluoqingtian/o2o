package com.bill.o2o.service;


public interface CaptchaService {
    int addSessionAndCaptcha(String sessionId,String captcha);
    int checkSessionAndCaptcha(String sessionId,String captcha);
}
