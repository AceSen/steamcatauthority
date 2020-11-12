package com.steamcat.authority.exception;

import com.steamcat.authority.constant.ErrorConst;
import com.steamcat.authority.entity.ResultEntity;
import com.steamcat.authority.utils.MessageSourceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName SteamCatExceptionHandler
 * @Description 全局异常处理
 * @Author Administrator
 * @Data 下午 10:44
 * @Version 1.0
 **/
@RestControllerAdvice
public class AuthExceptionExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(AuthException.class);

    @Autowired
    private MessageSourceUtils messageSourceUtils;

    @ExceptionHandler(value = Exception.class)
    public ResultEntity<AuthException> exceptionHandler(Exception exception) {
        exception.printStackTrace();
        if (exception instanceof AuthException) {
            AuthException authException = (AuthException) exception;
            String errorMessage = messageSourceUtils.getMessage(authException.getErrorCode());
            logger.error("error code:{}, error message:{}", authException.getErrorCode(), errorMessage);
            authException.setErrorMessage(errorMessage);
            return ResultEntity.fail(authException.getErrorCode(), authException.getErrorMessage());
        } else {
            logger.error("error message:{}", exception.getMessage());
            return ResultEntity.fail(ErrorConst.ERROR_CODE, ErrorConst.ERROR_MESSAGE);
        }
    }
}
