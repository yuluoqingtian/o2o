package com.bill.o2o.service.impl;

import com.bill.o2o.dao.CaptchaDao;
import com.bill.o2o.service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaptchaServiceImpl implements CaptchaService {

    @Autowired
    private CaptchaDao captchaDao;

    @Override
    public int addSessionAndCaptcha(String sessionId, String captcha) {
       return captchaDao.addSessionCaptcha(sessionId,captcha);
    }

    @Override
    public int checkSessionAndCaptcha(String sessionId, String captcha) {
        return captchaDao.checkSessionAndCaptcha(sessionId,captcha);
    }
}


