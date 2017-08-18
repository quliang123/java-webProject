package com.erma.servlet;

import com.erma.model.Classes;
import com.erma.model.Student;
import com.erma.model.Studentattendance;
import com.erma.model.User;
import com.erma.service.IClassesService;
import com.erma.service.IStudentService;
import com.erma.service.IStudentattendanceService;
import com.erma.service.IUserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 123 on 2017/08/11.
 */
@WebServlet(urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        String action = request.getParameter("action");

        if ("login".equals(action)) {
            String name = request.getParameter("uName");
            String pwd = request.getParameter("uPwd");


            IUserService userService = (IUserService) ctx.getBean("userService");

            User user = new User();
            user.setLogincode(name);
            user.setLoginpassword(pwd);
            int count = userService.isLogin(user);
            if (count > 0) {
                IClassesService classesService = (IClassesService) ctx.getBean("classesService");
                List<Classes> list = classesService.AllClass();
                request.setAttribute("lists", list);
                request.getRequestDispatcher("/main.jsp").forward(request, response);
            } else {
                response.sendRedirect("/login.jsp");
            }
        } else if ("search".equals(action)) {
            String search = request.getParameter("search");
            IStudentService studentService = (IStudentService) ctx.getBean("studentService");
            List<Student> list = studentService.getStusById(search);
            request.setAttribute("lists", list);
            request.setAttribute("id", search);
            request.getRequestDispatcher("/search.jsp").forward(request, response);
        } else if ("save".equals(action)) {
            String str = request.getParameter("arr");

            IStudentService studentService = (IStudentService) ctx.getBean("studentService");
            List<Student> li = studentService.getStusById(request.getParameter("id"));

            for (Student item : li) {
                String studentid = String.valueOf(item.getStudentid());
                String[] s = request.getParameterValues(studentid);

                Studentattendance studentattendance = new Studentattendance();
                for (String aid : s) {
                    System.out.println("aaaa" + aid);
                    studentattendance.setAttendanceid(Integer.parseInt(aid));
                }


                IStudentattendanceService studentattendanceService = (IStudentattendanceService) ctx.getBean("studentattendanceService");

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");


                studentattendance.setAttendancetime(new Date());

                studentattendance.setStudentid(Integer.valueOf(studentid).intValue());
                studentattendanceService.save(studentattendance);

            }


          /*  System.out.println(str);
            String[] ch = str.split(",");*/


            IClassesService classesService = (IClassesService) ctx.getBean("classesService");
            List<Classes> list = classesService.AllClass();
            request.setAttribute("lists", list);
            request.getRequestDispatcher("/main.jsp").forward(request, response);
        } else if ("s".equals(action)) {
            String time = request.getParameter("time");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = sdf.parse(time);

                IStudentattendanceService studentService = (IStudentattendanceService) ctx.getBean("studentattendanceService");
                List<Studentattendance> list = studentService.getAllStusByDate(date);

                for (Studentattendance item:list) {

                }

                request.setAttribute("list", list);
                request.getRequestDispatcher("/show.jsp").forward(request, response);

            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
    }
}
