package cn.ql.servlet;

import cn.ql.dao.IUserDAO;
import cn.ql.model.smbms_user;
import cn.ql.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 123 on 2017/07/12.
 */
@WebServlet(urlPatterns = "/userServlet")
public class userServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        System.out.println("action====" + action);

        if ("login".equals(action)) {
            String name = request.getParameter("username");
            String pwd = request.getParameter("password");

            smbms_user user = new smbms_user();
            user.setUserName(name);
            user.setUserPassword(pwd);
            boolean flag = dao.isLogin(user);

            if (flag) {


            } else {

            }
        }
    }
}
