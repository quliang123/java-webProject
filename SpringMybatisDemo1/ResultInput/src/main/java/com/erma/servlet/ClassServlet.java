package com.erma.servlet;

import com.erma.dao.ClassInfoMapper;
import com.erma.model.Class_info;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by 123 on 2017/08/09.
 */
@WebServlet(urlPatterns = {"/ClassServlet"})
public class ClassServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());


        String action = request.getParameter("action");

        if ("save".equals(action)) {
            String name = request.getParameter("name");
            System.out.println("name+++++"+name);
            ClassInfoMapper mapper = (ClassInfoMapper) ctx.getBean("classService");
            Class_info class_info = new Class_info();
            class_info.setCname(name);
            int count = mapper.saveClass(name);

            PrintWriter writer = response.getWriter();
            if (count > 0) {
                writer.print("y");
            } else {
                writer.print("n");
            }
            writer.flush();

        } else if ("manager".equals(action)) {
            ClassInfoMapper classInfoMapper = (ClassInfoMapper) ctx.getBean("classService");
            List<Class_info> list = classInfoMapper.getAllData();
            request.setAttribute("clist", list);
            System.out.println("进来了");
            request.getRequestDispatcher("/ClassManager.jsp").forward(request, response);
        }
    }
}
