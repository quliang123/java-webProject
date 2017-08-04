package cn.ql.servlet;

import cn.ql.dao.IBillDAO;
import cn.ql.dao.IProviderDAO;
import cn.ql.model.Page;
import cn.ql.model.smbms_bill;
import cn.ql.model.smbms_provider;
import cn.ql.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
    IProviderDAO pdao;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("进入billServlet");
        smbms_provider provider = new smbms_provider();
        smbms_bill bill = new smbms_bill();


        sqlSession = MybatisUtil.getSqlSession();
        dao = sqlSession.getMapper(IBillDAO.class);
        pdao = sqlSession.getMapper(IProviderDAO.class);


        String action = request.getParameter("action");

        System.out.println("action===========" + action);


        Page page = new Page();
        int pagesize = 2;
        int pageIndex = 1;

        page.setPageSize(pagesize);


        Map<String, Object> map = new HashMap<String, Object>();   //统计多条件查询的记录数

        //搜索商品
        String tempproductName = request.getParameter("productName");
        String productName = null;
        if (tempproductName != null) {
            productName = new String(tempproductName.getBytes("iso-8859-1"), "UTF-8");
        }
        System.out.println("==========================================" + productName);
        if (productName != null && productName.length() >= 1) {
            map.put("productName", productName);
            bill.setProductName(productName);
        } else {
            productName = "请输入商品的名称";
            map.put("productName", null);
        }
        request.setAttribute("productName", productName);

        //供应商
        String Temptigong = request.getParameter("tigong");
        int tigong = 0;
        String name = null;
        if (Temptigong != null) {
            tigong = Integer.parseInt(Temptigong);
            if (tigong == 0) {
                map.put("proName", null);
            } else {
                name = pdao.searchNameById(tigong);
                map.put("proName", name);
                request.setAttribute("Temptigong", Temptigong);
            }
        }

        //是否付款
        String Tempfukuan = request.getParameter("fukuan");
        int fukuan = 0;
        if (Tempfukuan != null) {
            fukuan = Integer.parseInt(Tempfukuan);
            if (fukuan == 2) {
                map.put("isPayment", null);
            } else {
                map.put("isPayment", fukuan);
                request.setAttribute("Tempfukuan", Tempfukuan);
            }
        }

        for (String key : map.keySet()) {
            System.out.println("mapkey" + map.get(key));
        }


        //3.总记录数
        int sum = 0;
        sum = dao.getBillCount(map);
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

            if (pageIndex < 1) {
                pageIndex = 1;
            } else if (pageIndex > pageCount) {
                pageIndex = pageCount;
            }
        } catch (Exception e) {
            pageIndex = 1;
        }


        /*if (name == null || tempproductName == null) {
            page.setPageIndex(0);
            System.out.println("if");
        } else {

        }*/
            page.setPageIndex(pageIndex);
            System.out.println("else" + page.getPageIndex());



        List<smbms_bill> list = dao.GetOneBillPageData(provider, bill, page);

        page.setBills(list);

        System.out.println(list.size());


        List<smbms_bill> bills = page.getBills();

        List<smbms_provider> providerlist = pdao.getAllProvider();

        page.setProviders(providerlist);


        if ("billList".equals(action)) {
            if (page.getPageIndex() == 0) {   //说名进行了模糊查询
                System.out.println("if");
                page.setPageIndex(1);
            } else {
                System.out.println("else");
                page.setPageIndex(pageIndex);
            }
            request.setAttribute("page", page);
            request.getRequestDispatcher("./billList.jsp").forward(request, response);
        }


    }
}
