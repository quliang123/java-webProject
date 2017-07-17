import cn.ql.dao.IUserDAO;
import cn.ql.model.smbms_user;
import cn.ql.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by 123 on 2017/07/13.
 */
public class UserTest {
    SqlSession sqlSession;
    IUserDAO dao;

    @Before    //在单测执行之前，会执行这个方法
    public void before() {
        sqlSession = MybatisUtil.getSqlSession();
        dao = sqlSession.getMapper(IUserDAO.class);
    }

    @org.junit.After    //无论哪个单测过了之后，就会执行的
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void TestIsLogin() {
        smbms_user user=new smbms_user();
        user.setUserName("123");
        user.setUserPassword("123");

        boolean flag=dao.isLogin(user);
        System.out.println(flag);
    }
}
