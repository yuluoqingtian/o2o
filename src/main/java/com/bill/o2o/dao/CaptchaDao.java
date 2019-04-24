package com.bill.o2o.dao;

import org.apache.ibatis.annotations.Param;

public interface CaptchaDao {
        int addSessionCaptcha(@Param("sessionId") String sessionId,
@Param("captcha") String captcha);

        int checkSessionAndCaptcha(@Param("sessionId") String sessionId,
@Param("captcha") String captcha);
        }
