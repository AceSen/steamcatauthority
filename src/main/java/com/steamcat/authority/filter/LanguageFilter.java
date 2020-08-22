package com.steamcat.authority.filter;

import com.steamcat.authority.utils.LanguageUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName LanguageFilter
 * @Description TODO
 * @Author Administrator
 * @Data 下午 11:12
 * @Version 1.0
 **/
public class LanguageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Cookie[] cookies = request.getCookies();
        String language = "zh";
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("language".equals(cookie.getName())) {
                    language = cookie.getValue();
                }
            }
        }
        LanguageUtils.setLanguage(language);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
