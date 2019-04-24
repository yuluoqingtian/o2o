package com.bill.o2o.util;

import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.Cookie;
import java.io.IOException;

public class CookiesUtil {
    public static String md5(String content, String randomNumber) {
        return DigestUtils.md5Hex(content + randomNumber);
    }

    public static Cookie createCookie(String cookieName, String content) throws IOException {

        Cookie cookie = new Cookie(cookieName, content);
        cookie.setPath("/");
        cookie.setSecure(false);
        cookie.setHttpOnly(false);
        cookie.setMaxAge(24 * 60 * 60);


        return cookie;
    }
}
