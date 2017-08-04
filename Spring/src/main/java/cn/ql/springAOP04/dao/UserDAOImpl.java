package cn.ql.springAOP04.dao;/**
 * Created by 123 on 2017/07/24.
 */

import cn.ql.springAOP04.entity.User;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/24
 * \* Time: 12:04
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
//实现类
public class UserDAOImpl implements IUserDAO {
    public void save(User user) {
        System.out.println("save  success");
    }
}
