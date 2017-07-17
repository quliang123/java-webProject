package dao;

import model.userinfo;

import java.util.List;

/**
 * Created by 123 on 2017/07/05.
 */
public interface IUserInfoDAO {

    public List<userinfo> getAllUser();

    public boolean isLogin(String UserName, String userPwd);

    public userinfo getUserByCondition(String UserName, String userPwd);

    public  boolean modifyUserIp(userinfo user);

}
