package com.steamcat.authority.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;
import java.util.Collection;

/**
 * @ClassName UserDetailEntity
 * @Description TODO
 * @Author Administrator
 * @Data 下午 05:45
 * @Version 1.0
 **/
public class UserDetailEntity extends User {
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public UserDetailEntity(UserEntity user) {
        super(user.getUserName(), user.getPassWord(),
                Arrays.asList(new SimpleGrantedAuthority(user.getRole())));
        this.mobile = user.getMobile();
    }
}
