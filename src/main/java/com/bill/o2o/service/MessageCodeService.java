package com.bill.o2o.service;

public interface MessageCodeService {
    int savePhoneNumberAndCode(String phoneNumber,String messageCode);
    int checkPhoneNumberAndCode(String phoneNumber,String messageCode);
}
