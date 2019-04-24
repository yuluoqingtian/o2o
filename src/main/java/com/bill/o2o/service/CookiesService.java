package com.bill.o2o.service;

import com.bill.o2o.entity.User;

public interface CookiesService {
    int addCookies(String userName,String userCookies,String passwordCookies);
    User checkCookies(String userCookies,String passwordCookies);
    int deleteCookiesByUserName(String userName);
}
