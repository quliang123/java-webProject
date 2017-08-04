package cn.ql.springAOP04.dao;

import cn.ql.springAOP04.entity.User;

/**
 * Created by 123 on 2017/07/24.
 */
//用户的接口
public interface IUserDAO {
    //保存用户
    public void save(User user);
}
