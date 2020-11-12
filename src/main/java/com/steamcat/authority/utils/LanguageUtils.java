package com.steamcat.authority.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * @ClassName LanguageUtils
 * @Description TODO
 * @Author Administrator
 * @Data 下午 11:10
 * @Version 1.0
 **/
@Component
public class LanguageUtils {
    @Autowired
    HttpServletRequest request;

    private static String getCountry(String language) {
        return "en".equals(language) ? "US" : "CN";
    }

    public Locale getLocale() {
        Cookie[] cookies = request.getCookies();
        String language = "zh";
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("language".equals(cookie.getName())) {
                    language = cookie.getValue();
                }
            }
        }
        return new Locale(language, getCountry(language));
    }
}
