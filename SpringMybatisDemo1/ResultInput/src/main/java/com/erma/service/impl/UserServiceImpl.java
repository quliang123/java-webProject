package com.erma.service.impl;


import com.erma.dao.UserInfoMapper;
import com.erma.service.IUserInfoService;

/**
 * Created by 123 on 2017/08/09.
 */

public class UserServiceImpl implements IUserInfoService {


    public UserInfoMapper getUserInfoMapper() {
        return userInfoMapper;
    }

    public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    private UserInfoMapper userInfoMapper;

    @Override
    public int isLogin(com.erma.model.UserInfo user) {
        return userInfoMapper.isLogin(user);
    }


}
