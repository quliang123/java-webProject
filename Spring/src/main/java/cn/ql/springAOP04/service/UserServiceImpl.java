package cn.ql.springAOP04.service;/**
 * Created by 123 on 2017/07/24.
 */

import cn.ql.springAOP04.dao.IUserDAO;
import cn.ql.springAOP04.dao.UserDAOImpl;
import cn.ql.springAOP04.entity.User;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/24
 * \* Time: 12:07
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class UserServiceImpl implements IUserService {


    private IUserDAO dao;

    public IUserDAO getImpl() {
        return dao;
    }

    public void setImpl(IUserDAO dao) {
        this.dao = dao;
    }

    @Override
    public void save(User user) {
        dao.save(user);
    }
}
