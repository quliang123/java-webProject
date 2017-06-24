package com.bdqn.servlet;

import com.bdqn.service.impl.ShowServiceDAOImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 123 on 2017/06/19.
 */
@WebServlet(name = "LoadServlet",urlPatterns = "/LoadServlet")
public class LoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding( "utf-8" );
        System.out.println("进来了");
        doGet( request, response );
    }

    ShowServiceDAOImpl Impl = new ShowServiceDAOImpl();
        Gson gson=new Gson();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data=null;
        try {
           data= Impl.show( "","",0,2 );
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

       List<Object[]> list=  gson.fromJson( data ,new TypeToken<List<Object[]>>(){}.getType());
            request.setAttribute( "list",list );
        request.setAttribute( "name","123" );
        for (Object[] item:list ) {
            System.out.println(item[0]+"===="+item[1]);
        }

         request.getRequestDispatcher( "/index.jsp" ).forward( request,response );
    }
}
