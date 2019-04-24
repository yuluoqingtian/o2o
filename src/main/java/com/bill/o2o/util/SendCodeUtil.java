package com.bill.o2o.util;

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

public class SendCodeUtil {
    public static int sendCode(String phoneNumber,String code){
        DefaultProfile profile = DefaultProfile.getProfile(
                //地域ID
                "cn-shenzhen",
                "LTAI8zdiYsw3zwqa",
                "nTUgQDLurKm3OfmffttTUmOl0hYGOr"
        );

        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();

        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", "VTake");
        request.putQueryParameter("TemplateCode", "SMS_160572343");
        request.putQueryParameter("TemplateParam",MessageCodeUtil.getSMSCodeString(code));


        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return 1;
        } catch (ClientException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
