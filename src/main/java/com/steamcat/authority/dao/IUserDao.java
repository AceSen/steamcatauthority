package com.steamcat.authority.dao;

import com.steamcat.authority.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * create by Administrator on  上午 01:48
 */
@Mapper
public interface IUserDao {
    UserEntity getUserByUserName(String userName);
}
