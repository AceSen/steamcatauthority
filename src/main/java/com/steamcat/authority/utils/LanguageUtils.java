package com.steamcat.authority.utils;

import java.util.Locale;

/**
 * @ClassName LanguageUtils
 * @Description TODO
 * @Author Administrator
 * @Data 下午 11:10
 * @Version 1.0
 **/
public class LanguageUtils {
    private static String language;
    private static String country;

    public static void setLanguage(String language) {
        LanguageUtils.language = language;
        LanguageUtils.country = getCountry();
    }

    private static String getCountry() {
        return "en".equals(LanguageUtils.language) ? "US" : "CN";
    }

    public static Locale getLocale() {
        return new Locale(LanguageUtils.language, LanguageUtils.country);
    }
}
