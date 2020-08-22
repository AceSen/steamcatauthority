package com.steamcat.authority.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName CookieUtils
 * @Description TODO
 * @Author Administrator
 * @Data 下午 11:16
 * @Version 1.0
 **/
public class CookieUtils {
    public static void addCookie(HttpServletResponse response, String domain, String path, String name, String value,
                                 int maxAge, boolean httpOnly){
        Cookie cookie = new Cookie(name, value);
        cookie.setDomain(domain);
        cookie.setMaxAge(maxAge);
        cookie.setPath(path);
        cookie.setHttpOnly(httpOnly);
        response.addCookie(cookie);
    }
}
