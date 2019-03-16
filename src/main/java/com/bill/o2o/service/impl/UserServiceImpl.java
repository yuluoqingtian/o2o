package com.bill.o2o.service.impl;

import com.bill.o2o.dao.UserDao;
import com.bill.o2o.entity.User;
import com.bill.o2o.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User checkAndReturnUser(String userName, String password) {
       return userDao.cheUserAndPassword(userName,password);
    }
}
