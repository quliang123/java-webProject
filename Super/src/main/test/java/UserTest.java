import cn.ql.dao.IUserDAO;
import cn.ql.model.Page;
import cn.ql.model.smbms_user;
import cn.ql.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

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

    @After    //无论哪个单测过了之后，就会执行的
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void TestmodifyUserInfo() throws ParseException {
        smbms_user user = new smbms_user();
        user.setId(554);
        user.setPhone("123456749");
        user.setGender(0);
        user.setUserName("六六六");
        user.setAddress("六六六");
        user.setUserType(3);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = "2017-7-17 10:30:12";
        Date parse = sdf.parse(time);
        user.setBirthday(parse);
        int i = dao.modifyUserInfo(user);
        System.out.println(i);
    }


    @Test
    public void TestdelUserById() {
        int count = dao.delUserById(554);
        System.out.println(count);
    }

    @Test
    public void TestAddUser() {
        smbms_user user = new smbms_user();
        user.setUserCode("AA-bb");
        user.setUserName("poxx");
        user.setUserPassword("abc");
        user.setAddress("神奇的东方");
        user.setPhone("88888888");
        user.setUserType(3);
        user.setGender(1);

        int i = dao.addUser(user);
        System.out.println(i);
    }

    @Test
    public void TestGetUserById() {
        smbms_user user = dao.getUserById(1);
        System.out.println(user.getUserName());
    }

    @Test
    public void TestgetUserCount() {
        Map<String, Object> map = new HashMap<String, Object>();
        String name = null;
        if (name != null) {
            map.put("name", name);
        } else {
            map.clear();
        }

        int count = dao.getUserCount(map);
        System.out.println(count);
    }


    @Test
    public void TestGetOneBillPageData() {
        smbms_user user = new smbms_user();
        user.setUserName("1");
        Page page = new Page();
        page.setPageIndex(0);
        page.setPageSize(2);
        List<smbms_user> list = dao.GetOneUserPageData(user, page);
        System.out.println(list.size());
    }


    @Test
    public void TestModifyPwd() {
        smbms_user user = new smbms_user();
        user.setId(1);
        user.setUserPassword("123");
        int count = dao.modifyPwd(user);
        System.out.println(count);
    }


    @Test
    public void TestFindUserByUser() {
        smbms_user user = new smbms_user();
        user.setUserName("123");
        user.setUserPassword("123");
        smbms_user u = dao.findUserByUser(user);
        System.out.println(u);
    }


    @Test
    public void TestIsLogin() {
        smbms_user user = new smbms_user();
        user.setUserName("123");
        user.setUserPassword("123");

        int flag = dao.isLogin(user);
        // System.out.println(flag);
        System.out.println(flag);
    }
}
