package servlet;

import com.google.gson.Gson;
import dao.IBlogsDAO;
import model.blogInfo;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;
import model.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by 123 on 2017/07/06.
 */
@WebServlet(urlPatterns = {"/BlogServlet"})
public class BlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    SqlSession sqlSession;
    IBlogsDAO dao;
    Gson gson = new Gson();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Blogs进来了");
        sqlSession = MybatisUtil.getSqlSession();
        dao = sqlSession.getMapper(IBlogsDAO.class);

        String action = request.getParameter("action");
        System.out.println("action" + action);


        Page page = new Page();
        System.out.println("action" + "----------" + action);
        //页大小
        int pagesize = 6;
        page.setPageSize(pagesize);

        //3.总记录数
        int count = 0;
        count = dao.getCount();
        page.setTotalrecords(count);


        int pageCount = 0;


        //总页数
        pageCount = count % pagesize == 0 ? count / pagesize : count / pagesize + 1;
        System.out.println(pagesize + "之后" + page.getPageSize());
        System.out.println("##############总页数" + pageCount);
        page.setTotalrecords(pageCount);


        System.out.println(page.getTotalrecords());

        //2.当前是第几页
        int pageIndex = 1;

        String pagesIndex = request.getParameter("pageIndex");
        try {
            if (request.getParameter("pageIndex") != null) {
                pageIndex = Integer.parseInt(pagesIndex);
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
        page.setPageIndex(pageIndex);


        System.out.println(page.getPageIndex() + "-------------" + page.getPageSize());

        if ("Blogslist".equals(action)) {
            List<blogInfo> list = dao.GetOnePageData(page.getPageIndex(), page.getPageSize());
            System.out.println("list" + list.size());
            String data = gson.toJson(list);
            page.setList(list);
            //request.setAttribute("list", list);
            request.setAttribute("page", page);
            request.getRequestDispatcher("BlogHtTemplate-master/html/bloglist.jsp").forward(request, response);
        } else if ("delBlog".equals(action)) {
            String tempId = request.getParameter("id");
            int id = 0;
            if (tempId != null) {
                id = Integer.parseInt(tempId);
            }
            boolean flag = dao.delBlog(id);
            if (flag) {
                sqlSession.commit();

                List<blogInfo> list = dao.GetOnePageData(page.getPageIndex(), page.getPageSize());
                page.setList(list);
                request.setAttribute("page", page);
                request.getRequestDispatcher("BlogHtTemplate-master/html/bloglist.jsp").forward(request, response);
            }
        } else if ("Info".equals(action)) {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html; charset=utf-8");

            PrintWriter out = response.getWriter();
            String tempId = request.getParameter("id");
            int id = 0;
            if (tempId != null) {
                id = Integer.parseInt(tempId);
            }
            blogInfo blogInfo = dao.getBlogInfo(id);

            Gson gson = new Gson();
            String data = gson.toJson(blogInfo);
            out.write(data);
        }

    }
}
