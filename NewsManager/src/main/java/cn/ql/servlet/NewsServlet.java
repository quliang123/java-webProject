package cn.ql.servlet;

import cn.ql.dao.INewsDAO;
import cn.ql.dao.ItalkDAO;
import cn.ql.model.Page;
import cn.ql.model.news;
import cn.ql.model.talk;
import cn.ql.utils.MybatisUtil;
import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 123 on 2017/07/21.
 */
@WebServlet(urlPatterns = {"/NewsServlet"})
public class NewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("newsServlet进来了");
        doGet(request, response);
    }

    INewsDAO dao;
    ItalkDAO tdao;
    SqlSession sqlSession;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        sqlSession = MybatisUtil.getSqlSession();
        dao = sqlSession.getMapper(INewsDAO.class);
        tdao = sqlSession.getMapper(ItalkDAO.class);

        String action = request.getParameter("action");
        System.out.println(action);


        Page page = new Page();
        int pagesize = 3;
        int pageIndex = 0;

        page.setPageSize(pagesize);
        //3.总记录数
        int sum = 0;
        sum = dao.getCount();
        page.setTotalrecords(sum);

        int pageCount = 0;
        System.out.println("sum=============================" + sum);
        //总页数
        pageCount = sum % pagesize == 0 ? sum / pagesize : sum / pagesize + 1;
        System.out.println(pagesize + "之后" + page.getPageSize());
        System.out.println("##############总页数" + pageCount);
        page.setTotlePages(pageCount);

        System.out.println("Totalrecords" + page.getTotalrecords());


        String pagesIndex = null;
        String tempIndex = request.getParameter("pageIndex");
        try {
            if (tempIndex != null) {
                pageIndex = Integer.parseInt(tempIndex);
                System.out.println("当前index" + pageIndex);
            }

            if (pageIndex < -1) {
                pageIndex = 0;
            } else if (pageIndex > pageCount) {
                pageIndex = pageCount;
            }
        } catch (Exception e) {
            pageIndex = 0;
        }
        page.setPageIndex(pageIndex);

        List<news> list = dao.getOnePageData(page);
        for (news item : list) {
            System.out.println("================" + item.getNewsid());
            int talkCount = dao.getTalkCount(item.getNewsid());
            if (talkCount == 0) {
                item.setTcount(0);
            } else {
                item.setTcount(talkCount);
            }
        }

        System.out.println("list" + list.size());
        page.setNewsList(list);

        request.setAttribute("page", page);
        request.setAttribute("list", list);

        if (page.getPageIndex() == 0) {
            page.setPageIndex(1);
        }

        System.out.println("====================================" + action);
        if ("pl".equals(action)) {
            String pl = request.getParameter("pl");
            String tempID = request.getParameter("id");
            int id = 0;
            if (tempID != null) {
                id = Integer.parseInt(tempID);
            }
            talk talk = new talk();
            talk.setContent(pl);
            talk.setTalktime(new Date());
            talk.setNid(id);
            int i = tdao.addTalk(talk);

            List<talk> talkList = tdao.getTalkList(id);
            for (talk item : talkList) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
                String format = sdf.format(item.getTalktime());
                item.setTime(format);
            }

            String tempMsg = request.getParameter("msg");
            if (tempMsg != null) {
                String msg = new String(tempMsg.getBytes("iso-8859-1"), "UTF-8");
                request.setAttribute("msg", msg);
            }

            request.setAttribute("talkList", talkList);
            request.getRequestDispatcher("./2.jsp").forward(request, response);

        } else if ("look".equals(action)) {
            String tempId = request.getParameter("id");
            int id = 0;
            if (tempId != null) {
                id = Integer.parseInt(tempId);
                request.setAttribute("id", id);
            }
            List<talk> talkList = tdao.getTalkList(id);
            for (talk item : talkList) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
                String format = sdf.format(item.getTalktime());
                item.setTime(format);
            }


            List<news> data = dao.getOnePageData(page);
            for (news item : data) {
                Integer integer = item.getClickcount()+1;
                // int i = 0;
                news news = new news();
                news.setNewsid(id);
                news.setClickcount(integer);

                boolean b = dao.updateCount(news);

                if (b) {
                    System.out.println("更新成功");
                    sqlSession.commit();
                }


            }


            String tempMsg = request.getParameter("msg");
            if (tempMsg != null) {
                String msg = new String(tempMsg.getBytes("iso-8859-1"), "UTF-8");
                request.setAttribute("msg", msg);
            }


            request.setAttribute("talkList", talkList);
            request.getRequestDispatcher("./2.jsp").forward(request, response);

        } else {
            // request.setAttribute("page", page);
            System.out.println("进来了");
            request.getRequestDispatcher("./index.jsp").forward(request, response);
        }
    }
}
