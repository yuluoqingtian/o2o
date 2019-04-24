package com.bill.o2o.entity;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.ecs.model.v20140526.DescribeInstancesRequest;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.bill.o2o.util.MessageCodeUtil;
import com.bill.o2o.util.SendCodeUtil;

public class MessageTest {
    public static void main(String[] args) {

       String code = MessageCodeUtil.createCode();

        System.out.println( SendCodeUtil.sendCode("13750433270",code));



    }
}
