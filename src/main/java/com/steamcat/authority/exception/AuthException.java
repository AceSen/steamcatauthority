package com.steamcat.authority.exception;

import org.springframework.stereotype.Component;

/**
 * @ClassName SteamCatException
 * @Description 全局异常类
 * @Author Administrator
 * @Data 下午 10:21
 * @Version 1.0
 **/
public class AuthException extends RuntimeException {
    private String errorCode;
    private String errorMessage;


    public AuthException(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
