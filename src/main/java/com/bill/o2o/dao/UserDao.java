package com.bill.o2o.dao;

import com.bill.o2o.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User checkUserAndPassword(@Param("userName") String userName,
                            @Param("password") String password);

    User getUserByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    int insertUser(@Param("user") User user);
}
