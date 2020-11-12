package com.steamcat.authority.service;

import com.steamcat.authority.entity.AuthToken;
import com.steamcat.authority.entity.LoginParam;

import javax.servlet.http.HttpServletRequest;

/**
 * create by Administrator on  下午 06:53
 */
public interface IJwtTokenService {
    /**
    * @author
    * @Description 生成用户token
    * @Date
    * @Param loginParam
    * @Return String 用户token
    **/
    String generateToken(LoginParam loginParam);
    /**
    * @author
    * @Description 获取用户身份信息的令牌
    * @Date
    * @Param HttpServletRequest
    * @Return
    **/
    AuthToken getJwt(HttpServletRequest request);

    /**
     * @author
     * @Description 用户登出
     * @Date
     * @Param HttpServletRequest
     * @Return
     **/
    boolean loginOut(HttpServletRequest request);
}
