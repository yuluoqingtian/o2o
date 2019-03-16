package com.bill.o2o.service;

import org.springframework.stereotype.Service;

public interface CaptchaService {
    int addSessionAndCaptcha(String sessionId,String captcha);
    int checkSessionAndCaptcha(String sessionId,String captcha);
}
