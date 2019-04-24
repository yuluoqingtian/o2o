package com.bill.o2o.service.impl;

import com.bill.o2o.dao.MessageCodeDao;
import com.bill.o2o.service.MessageCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageCodeServiceImpl implements MessageCodeService {

    @Autowired
    private MessageCodeDao messageCodeDao;

    @Override
    public int savePhoneNumberAndCode(String phoneNumber, String messageCode) {
        return messageCodeDao.savePhoneNumberAndCode(phoneNumber,messageCode);
    }

    @Override
    public int checkPhoneNumberAndCode(String phoneNumber, String messageCode) {
        return messageCodeDao.checkPhoneNumberAndCode(phoneNumber,messageCode);
    }
}
