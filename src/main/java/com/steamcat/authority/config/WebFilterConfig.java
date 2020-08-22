package com.steamcat.authority.config;

import com.steamcat.authority.filter.LanguageFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName WebFilterConfig
 * @Description TODO
 * @Author Administrator
 * @Data 上午 12:50
 * @Version 1.0
 **/
@Configuration
public class WebFilterConfig {
    @Bean
    public FilterRegistrationBean LanguageRegistration() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new LanguageFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
