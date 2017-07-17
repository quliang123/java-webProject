package cn.ql.dao;

import cn.ql.model.Page;
import cn.ql.model.smbms_user;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by 123 on 2017/07/12.
 */
public interface IUserDAO {
    public int modifyUserInfo(@Param("user") smbms_user user);

    public int delUserById(int id);

    public int addUser(smbms_user user);

    public smbms_user getUserById(int id);

    public List<smbms_user> likeUser(String name);

    public int getUserCount(Map<String, Object> map);

    public List<smbms_user> GetOneUserPageData(@Param("user") smbms_user user, @Param("page") Page page);

    public int isLogin(smbms_user user);

    public smbms_user findUserByUser(smbms_user user);

    public int modifyPwd(smbms_user user);

}
