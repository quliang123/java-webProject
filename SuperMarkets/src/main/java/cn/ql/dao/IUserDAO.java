package cn.ql.dao;

import cn.ql.model.smbms_user;

/**
 * Created by 123 on 2017/07/12.
 */
public interface IUserDAO {
    public boolean isLogin(smbms_user user);

    public smbms_user findUserByUser(smbms_user user);


}
