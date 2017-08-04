package com.ql.service;

import com.ql.model.User;

/**
 * Created by 123 on 2017/08/01.
 */
public interface IUserService {
    public User selectUserById(Integer userId);
}
