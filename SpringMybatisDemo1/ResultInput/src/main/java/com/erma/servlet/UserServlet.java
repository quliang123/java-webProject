package com.erma.servlet;

import com.erma.model.UserInfo;
import com.erma.service.IUserInfoService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 123 on 2017/08/09.
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
            IUserInfoService userService = (IUserInfoService) ctx.getBean("userService");

            UserInfo user = new UserInfo();
            user.setUsername(request.getParameter("uName"));
            user.setUserpwd(request.getParameter("uPwd"));

            int count = userService.isLogin(user);
            if (count > 0) {
                System.out.println("登陆成功！！！！");
                request.getSession().setAttribute("userName", user.getUsername());
                request.getRequestDispatcher("/welcome.jsp").forward(request, response);
            } else {
                response.sendRedirect("./login.jsp");
            }

        } else if ("logout".equals(action)) {
            request.getSession().removeAttribute("userName");
            response.sendRedirect("./login.jsp");
        }

    }
}
