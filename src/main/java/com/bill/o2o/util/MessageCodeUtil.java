package com.bill.o2o.util;

import jdk.internal.dynalink.beans.StaticClass;

public class MessageCodeUtil {
    public static String getSMSCodeString(String code){
        return "{\"code\":"+"\""+code+"\"}";
    }

    public static String createCode(){
        return String.valueOf((int)((Math.random()*9+1)*100000));
    }
}
