package com.steamcat.authority.service;

import com.alibaba.fastjson.JSONObject;
import com.steamcat.authority.entity.LoginParam;

/**
 * create by Administrator on  下午 06:53
 */
public interface IJwtTokenService {
    String generateToken(LoginParam loginParam);
}
