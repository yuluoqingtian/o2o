package com.bill.o2o.dao;

import org.apache.ibatis.annotations.Param;

public interface MessageCodeDao {
    int savePhoneNumberAndCode(@Param("phoneNumber")String phoneNumber,
                               @Param("messageCode")String messageCode);

    int checkPhoneNumberAndCode(@Param("phoneNumber")String phoneNumber,
                                @Param("messageCode")String messageCode);
}
