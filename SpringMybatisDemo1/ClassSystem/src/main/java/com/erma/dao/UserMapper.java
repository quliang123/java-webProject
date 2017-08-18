package com.erma.dao;

import com.erma.model.User;

public interface UserMapper {

    public int isLogin(User user);

    int deleteByPrimaryKey(Integer loginid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer loginid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}