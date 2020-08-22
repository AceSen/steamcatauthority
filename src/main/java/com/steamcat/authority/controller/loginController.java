package com.steamcat.authority.controller;

import com.alibaba.fastjson.JSONObject;
import com.steamcat.authority.entity.LoginParam;
import com.steamcat.authority.entity.ResultEntity;
import com.steamcat.authority.exception.AuthException;
import com.steamcat.authority.service.IJwtTokenService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName loginController
 * @Description TODO
 * @Author Administrator
 * @Data 下午 06:44
 * @Version 1.0
 **/
@RestController
@RequestMapping("/authority")
public class loginController {

    @Autowired
    IJwtTokenService JwtTokenService;

    @PostMapping("/login")
    public ResultEntity login(@RequestBody LoginParam loginParam){
        String passWord = loginParam.getPassWord();
        String userName = loginParam.getUserName();
        if (StringUtils.isEmpty(userName)) {
            throw new AuthException("com.authority.1002");
        }
        if (StringUtils.isEmpty(passWord)) {
            throw new AuthException("com.authority.1003");
        }
        String token = JwtTokenService.generateToken(loginParam);
        return ResultEntity.success(token);
    }
}
