package servlet;

import dao.IUserInfoDAO;
import model.userinfo;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

/**
 * Created by 123 on 2017/07/05.
 */
@WebServlet(urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    IUserInfoDAO dao;
    SqlSession sqlSession;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sqlSession = MybatisUtil.getSqlSession();
        dao = sqlSession.getMapper(IUserInfoDAO.class);


        System.out.println("进入servlet");
        String action = request.getParameter("action");
        System.out.println("12333" + action);

        if ("login".equals(action)) {
            String name = request.getParameter("name");
            String pwd = request.getParameter("pwd");

            boolean flag = dao.isLogin(name, pwd);
            System.out.println(flag);

            if (flag) {
                userinfo user = dao.getUserByCondition(name, pwd);

                String Ip = getIpAddr(request);
                System.out.println(Ip + "==" + name + "==" + pwd);

                userinfo userinf = new userinfo();
                userinf.setUserPwd(pwd);
                userinf.setUserName(name);


                //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
                Date date=new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

                System.out.println(sdf.format(date));

                userinf.setIp(Ip);
                  userinf.setLastLoginTime(sdf.format(date));
                boolean ok = dao.modifyUserIp(userinf);

                if (ok) {
                    System.out.println("记录ip成功!");
                    sqlSession.commit();
                }
                sqlSession.close();

                System.out.println("user"+user.getUserName()+user.getLastLoginTime()+user.getUserPwd());
                request.getSession().setAttribute("user", user);
                request.getRequestDispatcher("BlogHtTemplate-master/html/main.jsp").forward(request, response);
            } else {
                response.sendRedirect("BlogHtTemplate-master/html/index.jsp");
            }

        }
    }


    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
