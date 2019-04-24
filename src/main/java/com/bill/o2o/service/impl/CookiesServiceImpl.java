package com.bill.o2o.service.impl;

import com.bill.o2o.dao.CookiesDao;
import com.bill.o2o.entity.User;
import com.bill.o2o.service.CookiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookiesServiceImpl implements CookiesService {

    @Autowired
    private CookiesDao cookiesDao;

    @Override
    public int addCookies(String userName, String userCookies, String passwordCookies) {
        return cookiesDao.addCookie(userName,userCookies,passwordCookies);
    }

    @Override
    public User checkCookies(String userCookies, String passwordCookies) {
        return cookiesDao.checkCookie(userCookies,passwordCookies);
    }

    @Override
    public int deleteCookiesByUserName(String userName) {
        return cookiesDao.deleteCookiesByUserName(userName);
    }
}
