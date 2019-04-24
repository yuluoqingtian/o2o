package com.bill.o2o.service;

import com.bill.o2o.entity.User;

public interface UserService {
    User checkAndReturnUser(String userName ,String password);
    User getUserByPhoneNumber(String phoneNumber);
    int insertUser(User user);
}
