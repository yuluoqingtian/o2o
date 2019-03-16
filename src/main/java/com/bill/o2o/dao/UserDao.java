package com.bill.o2o.dao;

import com.bill.o2o.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User cheUserAndPassword(@Param("userName") String userName,
                            @Param("password") String password);
}
