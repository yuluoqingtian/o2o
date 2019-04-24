package com.bill.o2o.dao;

import com.bill.o2o.entity.User;
import org.apache.ibatis.annotations.Param;

public interface CookiesDao {

    int addCookie (@Param("userName") String userName,
                   @Param("userCookie") String userCookie,
                   @Param("passwordCookie")String passwordCookie);

    User checkCookie(@Param("userCookie") String userCookie,
                     @Param("passwordCookie")String passwordCookie);

    int deleteCookiesByUserName(@Param("userName") String userName);
}
