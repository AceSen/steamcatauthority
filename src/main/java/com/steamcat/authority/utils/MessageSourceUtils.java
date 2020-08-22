package com.steamcat.authority.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName MessageSourceUilts
 * @Description TODO
 * @Author Administrator
 * @Data 下午 11:57
 * @Version 1.0
 **/
@Component
public class MessageSourceUtils {
    @Value("${spring.messages.basename}")
    private String baseName;
    @Value("${spring.messages.encoding}")
    private String encoding;
    private static MessageSource messageSource;


    private ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
    @PostConstruct
    public void initMessageSource() {
        bundleMessageSource.setBasenames(baseName);
        bundleMessageSource.setDefaultEncoding(encoding);
        setMessageSource(bundleMessageSource);
    }

    private static void setMessageSource(ReloadableResourceBundleMessageSource bundleMessageSource) {
        messageSource = bundleMessageSource;
    }

    public static String getMessage(String key) {
        return messageSource.getMessage(key, null, LanguageUtils.getLocale());
    }
}
