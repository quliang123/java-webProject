package com.ql.dao;

import com.ql.model.User;

/**
 * Created by 123 on 2017/08/01.
 */
public interface IUserDAO {
    /**
     * @param userId
     * @author 123
     */
    public User selectUserById(Integer userId);

}
