package cn.ql.servlet;

import cn.ql.dao.IUserDAO;
import cn.ql.model.Page;
import cn.ql.model.smbms_user;
import cn.ql.utils.GetAge;
import cn.ql.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.AlgorithmConstraints;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 123 on 2017/07/12.
 */
@WebServlet(urlPatterns = {"/userServlet"})
public class userServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    SqlSession sqlSession;
    IUserDAO dao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        sqlSession = MybatisUtil.getSqlSession();
        dao = sqlSession.getMapper(IUserDAO.class);

        request.setCharacterEncoding("UTF-8");


        //分页
        //页大小

        Page page = new Page();
        int pagesize = 2;
        int pageIndex = 1;

        page.setPageSize(pagesize);

        smbms_user user = new smbms_user();
        String search = request.getParameter("search");

        Map<String, Object> map = new HashMap<String, Object>();
        if (search != null) {
            user.setUserName(search);
            map.put("name", search);
            pageIndex = 0;
        } else {
            user.setUserName("");
            map.clear();
        }


        System.out.println("search===" + user.getUserName());


        //3.总记录数
        int sum = 0;
        sum = dao.getUserCount(map);
        page.setTotalrecords(sum);

        int pageCount = 0;
        System.out.println(sum);
        //总页数
        pageCount = sum % pagesize == 0 ? sum / pagesize : sum / pagesize + 1;
        System.out.println(pagesize + "之后" + page.getPageSize());
        System.out.println("##############总页数" + pageCount);
        page.setTotalrecords(pageCount);


        System.out.println("Totalrecords" + page.getTotalrecords());

        //2.当前是第几页

        String pagesIndex = null;
        String tempIndex = request.getParameter("pageIndex");

        try {
            if (tempIndex != null) {
                pageIndex = Integer.parseInt(tempIndex);
                System.out.println("当前index" + pageIndex);
            }

            if (pageIndex < 1) {
                pageIndex = 1;
            } else if (pageIndex > pageCount) {
                pageIndex = pageCount;
            }
        } catch (Exception e) {
            pageIndex = 1;
        }


        if (search != null) {
            page.setPageIndex(0);
        } else {
            page.setPageIndex(pageIndex);
        }


        List<smbms_user> list = dao.GetOneUserPageData(user, page);
        for (smbms_user item : list) {
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

            Date birthday = item.getBirthday();
            String format = null;
            int age = 0;
            if (birthday != null) {
                format = date.format(birthday);
                try {
                    age = GetAge.getage(format);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }


            item.setAge(age);
        }
        page.setUsers(list);

        System.out.println(page.getPageIndex() + "-------------" + page.getPageSize());

        System.out.println("==========================" + page.getPageIndex());


        if (page.getPageIndex() == 0) {   //说名进行了模糊查询
            System.out.println("if");
            page.setPageIndex(1);
        } else {
            System.out.println("else");
            page.setPageIndex(pageIndex);
        }


        System.out.println("action====" + action);

        if ("login".equals(action)) {
            String name = request.getParameter("username");
            String pwd = request.getParameter("password");

            System.out.println(name + "=======" + pwd);

           /* smbms_user user = new smbms_user();
            user.setUserName(name);
            user.setUserPassword(pwd);*/


            user = new smbms_user();
            user.setUserName(name);
            user.setUserPassword(pwd);
            System.out.println(user);

            System.out.println(user.getUserName() + "=======" + user.getUserPassword());

            int i = dao.isLogin(user);
            System.out.println(i);

            int flag = dao.isLogin(user);

            System.out.println("flag" + flag);

            smbms_user u = dao.findUserByUser(user);
            request.getSession().setAttribute("user", u);
            if (flag > 0) {
                request.getRequestDispatcher("./welcome.jsp").forward(request, response);
            } else {
                response.sendRedirect("./login.jsp");
            }
        } else if ("logout".equals(action)) {
            request.getSession().removeAttribute("user");
            response.sendRedirect("./login.jsp");
        } else if ("modify".equals(action)) {
            user = new smbms_user();
            String pwd = request.getParameter("reNewPassword");
            String tempId = request.getParameter("id");
            int id = 0;
            if (tempId != null) {
                id = Integer.parseInt(tempId);
            }

            System.out.println(id + "=======" + pwd);
            user.setId(id);
            user.setUserPassword(pwd);

            int count = dao.modifyPwd(user);
            PrintWriter out = response.getWriter();
            if (count > 0) {
                out.write("y");
            } else {
                out.write("n");
            }
            sqlSession.close();
            out.flush();
            out.close();

        } else if ("userList".equals(action)) {

            if (page.getTotalrecords() == 0) {
                page.setPageIndex(0);
            }

            System.out.println("size" + page.getUsers().size());

            request.setAttribute("page", page);
            request.getRequestDispatcher("./userList.jsp").forward(request, response);
        } else if ("UserDetails".equals(action)) {
            String tempId = request.getParameter("id");
            int id = 0;
            if (tempId != null) {
                id = Integer.parseInt(tempId);
            }

            smbms_user u = dao.getUserById(id);

            request.setAttribute("user", u);

            request.getRequestDispatcher("./userView.jsp").forward(request, response);
        } else if ("addUser".equals(action)) {
            String userCode = request.getParameter("userId");
            String userName = request.getParameter("userName");
            String userpassword = request.getParameter("userpassword");
            String gender = request.getParameter("gender");
            int genderId = 0;
            if ("男".equals(gender)) {
                genderId = 1;
            }
            String birth = request.getParameter("data");

            request.setAttribute("page", page);


            String reg = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";
            Pattern p1 = Pattern.compile(reg);
            Matcher m1 = null;
            if (birth != null) {
                m1 = p1.matcher(birth);
            }
            if (!m1.matches()) {
                System.out.println("被正则拦截");
                request.getRequestDispatcher("./userAdd.jsp").forward(request, response);
                return;
            }


            String userphone = request.getParameter("userphone");
            String userAddress = request.getParameter("userAddress");


            String userlei = request.getParameter("userlei");
            int userType = 0;
            if ("管理员".equals(userlei)) {
                userType = 1;
            } else if ("经理".equals(userlei)) {
                userType = 2;
            } else if ("普通用户".equals(userlei)) {
                userType = 3;
            }

            smbms_user u = new smbms_user();
            u.setAddress(userAddress);
            u.setUserCode(userCode);
            u.setUserName(userName);
            u.setPhone(userphone);
            u.setUserPassword(userpassword);
            u.setUserType(userType);
            u.setGender(genderId);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date time = null;
            try {
                time = sdf.parse(birth);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            u.setBirthday(time);

            int i = dao.addUser(u);

            if (i > 0) {

                //3.总记录数
                int num = 0;
                num = dao.getUserCount(map);
                page.setTotalrecords(num);

                pageCount = 0;
                System.out.println(num);
                //总页数
                pageCount = num % pagesize == 0 ? num / pagesize : num / pagesize + 1;
                System.out.println(pagesize + "aaaaa之后" + page.getPageSize());
                System.out.println("hhhhhhhhhhhhh总页数" + pageCount);
                page.setTotalrecords(pageCount);

                sqlSession.commit();
                sqlSession.close();
                request.getRequestDispatcher("./userList.jsp").forward(request, response);
            }
        } else if ("delUser".equals(action)) {
            PrintWriter out = response.getWriter();
            String tempId = request.getParameter("id");
            int id = 0;
            if (tempId != null) {
                id = Integer.parseInt(tempId);
            }
            System.out.println("id" + id);
            int count = dao.delUserById(id);
            System.out.println("count" + count);
            if (count > 0) {
                out.write("y");
            } else {
                out.write("n");
            }

            //3.总记录数
            int num = 0;
            num = dao.getUserCount(map);
            page.setTotalrecords(num);

            pageCount = 0;
            System.out.println(num);
            //总页数
            pageCount = num % pagesize == 0 ? num / pagesize : num / pagesize + 1;
            page.setTotalrecords(pageCount);


            sqlSession.commit();
            out.flush();
            out.close();
        } else if ("GoModify".equals(action)) {
            String tempId = request.getParameter("id");
            int id = 0;
            if (tempId != null) {
                id = Integer.parseInt(tempId);
            }

            smbms_user u = dao.getUserById(id);

            request.setAttribute("user", u);

            request.getRequestDispatcher("./userUpdate.jsp").forward(request, response);
        } else if ("modifyUser".equals(action)) {

            System.out.println("进来了吧");
            String tempId = request.getParameter("id");
            int id = 0;
            if (tempId != null) {
                id = Integer.parseInt(tempId);
            }

            String userName = request.getParameter("userName");
            String gender = request.getParameter("gender");
            int genderId = 0;
            if ("男".equals(gender)) {
                genderId = 1;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String data = request.getParameter("data");

            String reg = "(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)";
            Pattern p1 = Pattern.compile(reg);
            Matcher m1 = null;
            if (data != null) {
                m1 = p1.matcher(data);
            }
            if (!m1.matches()) {
                System.out.println("被正则拦截");
                request.getRequestDispatcher("./userUpdate.jsp").forward(request, response);
                return;
            }

            Date time = null;
            try {
                time = sdf.parse(data);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String userphone = request.getParameter("userphone");

            String userAddress = request.getParameter("userAddress");

            String userlei = request.getParameter("userlei");

            String templei = new String(userlei.getBytes("iso-8859-1"), "utf-8");
            System.out.println("类型" + templei);
            int userType = 0;
            if ("管理员".equals(templei)) {
                userType = 1;
            } else if ("经理".equals(templei)) {
                userType = 2;
            } else if ("普通用户".equals(templei)) {
                userType = 3;
            }


            smbms_user u = new smbms_user();
            u.setId(id);
            u.setUserName(userName);
            u.setPhone(userphone);
            u.setBirthday(time);
            u.setUserType(userType);
            u.setAddress(userAddress);
            u.setGender(genderId);
            int i = dao.modifyUserInfo(u);


            System.out.println(id + "==" + userName + "==" + userphone + "==" + time + "==" + userType + "==" + userAddress + "==" + "==" + genderId);
            System.out.println("==========" + i);
            if (i > 0) {
                sqlSession.commit();
                sqlSession.close();
                request.setAttribute("page", page);
                request.getRequestDispatcher("./userList.jsp").forward(request, response);
            }


        }

    }
}
