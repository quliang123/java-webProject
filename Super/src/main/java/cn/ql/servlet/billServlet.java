package cn.ql.servlet;

import cn.ql.dao.IBillDAO;
import cn.ql.model.Page;
import cn.ql.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 123 on 2017/07/17.
 */
@WebServlet(urlPatterns = {"/billServlet"})
public class billServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }


    SqlSession sqlSession;
    IBillDAO dao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        sqlSession = MybatisUtil.getSqlSession();
        dao = sqlSession.getMapper(IBillDAO.class);

        System.out.println("action===========" + action);


        Page page = new Page();
        int pagesize = 2;
        int pageIndex = 1;

        page.setPageSize(pagesize);

        Map<String, Object> map = new HashMap<String, Object>();





        //3.总记录数
        int sum = 0;
          sum = dao.getBillCount(map);
        page.setTotalrecords(sum);

        int pageCount = 0;
        System.out.println(sum);
        //总页数
        pageCount = sum % pagesize == 0 ? sum / pagesize : sum / pagesize + 1;
        System.out.println(pagesize + "之后" + page.getPageSize());
        System.out.println("##############总页数" + pageCount);
        page.setTotalrecords(pageCount);


        System.out.println("Totalrecords" + page.getTotalrecords());

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


    }
}
