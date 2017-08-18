package com.erma.service;

import com.erma.dao.UserMapper;
import com.erma.model.User;

/**
 * Created by 123 on 2017/08/11.
 */

public class UserServiceImpl implements IUserService{
    @Override
    public int isLogin(User user) {
        return userMapper.isLogin(user);
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    private UserMapper userMapper;

    }
