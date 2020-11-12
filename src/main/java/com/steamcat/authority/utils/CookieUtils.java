package com.steamcat.authority.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CookieUtils
 * @Description TODO
 * @Author Administrator
 * @Data 下午 11:16
 * @Version 1.0
 **/
public class CookieUtils {
    // 往response中写cookie
    public static void addCookie(HttpServletResponse response, String domain, String path, String name, String value,
                                 int maxAge, boolean httpOnly){
        Cookie cookie = new Cookie(name, value);
        cookie.setDomain(domain);
        cookie.setMaxAge(maxAge);
        cookie.setPath(path);
        cookie.setHttpOnly(httpOnly);
        response.addCookie(cookie);
    }

    public static Map<String, String> getCookie(HttpServletRequest request, String ... cookieNames) {
        Map<String, String> map = new HashMap<>();
        Cookie[] cookies = request.getCookies();
        if (cookies ==null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            for (int i = 0; i < cookieNames.length; i++) {
                if (cookie.getName().equals(cookieNames[i])) {
                    map.put(cookie.getName(), cookie.getValue());
                }
            }
        }
        return map;
    }
}
