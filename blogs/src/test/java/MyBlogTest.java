import dao.IUserInfoDAO;
import model.userinfo;
import org.apache.commons.dbutils.DbUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.MybatisUtil;

import java.util.List;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.After;
import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

/**
 * Created by 123 on 2017/07/05.
 */
public class MyBlogTest {
    SqlSession sqlSession;
    IUserInfoDAO dao;

    @Before    //在单测执行之前，会执行这个方法
    public void before() {
        sqlSession = MybatisUtil.getSqlSession();
        dao = sqlSession.getMapper(IUserInfoDAO.class);
    }

    @After    //无论哪个单测过了之后，就会执行的
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void TestLogin() {
        boolean count = dao.isLogin("123", "123456");
        System.out.println(count);
    }


    @Test
    public void TestgetUserById() {
        userinfo user = dao.getUserByCondition("123", "123456");
        System.out.println(user.getUserName());
    }


    @Test
    public void TestGetAll() {
        List<userinfo> list = dao.getAllUser();
        for (userinfo item : list) {
            System.out.println(item.getUserName());
        }
    }

    @Test
    public void TestMoify() {
        userinfo user =new userinfo();
        user.setIp("123456");
        user.setLastLoginTime("2017-10");
        user.setUserName("123");
        user.setUserPwd("123456");
          boolean flag= dao.modifyUserIp(user);
        System.out.println( flag);
    }



}
