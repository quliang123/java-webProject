package com.ql.service;

import com.ql.dao.IUserDAO;
import com.ql.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 123 on 2017/08/01.
 */
@Service
public class UserServiceImpl implements IUserService {
     @Autowired
    private IUserDAO userDAO;

    @Override
    public User selectUserById(Integer userId) {
        return userDAO.selectUserById(userId);
    }
}
