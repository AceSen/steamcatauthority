package com.steamcat.authority.service.impl;

import com.steamcat.authority.dao.IUserDao;
import com.steamcat.authority.entity.UserDetailEntity;
import com.steamcat.authority.entity.UserEntity;
import com.steamcat.authority.exception.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @ClassName UserDetailsServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Data 上午 01:41
 * @Version 1.0
 **/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    IUserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String userName) {
        UserEntity user = userDao.getUserByUserName(userName);
        UserDetailEntity userDetail = new UserDetailEntity(user);

        return userDetail;
    }
}
