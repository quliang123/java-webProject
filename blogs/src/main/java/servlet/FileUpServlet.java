package servlet;

import dao.IBlogsDAO;
import model.Page;
import model.blogInfo;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.Key;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 123 on 2017/07/08.
 */
@WebServlet(urlPatterns = {"/FileUpServlet"})
public class FileUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    SqlSession sqlSession;
    IBlogsDAO dao;

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
        if ("FileUp".equals(action)) {     //文件上传
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8");
            factory.setSizeThreshold(1024 * 500);//设置内存的临界值为500K
            File linshi = new File("E:\\linshi");//当超过500K的时候，存到一个临时文件夹中
            factory.setRepository(linshi);
            upload.setSizeMax(1024 * 1024 * 5);//设置上传的文件总的大小不能超过5M
            Map<Object, Object> map = new HashMap<Object, Object>();
            try {
                // 1. 得到 FileItem 的集合 items
                List<FileItem> /* FileItem */items = upload.parseRequest(request);


                // 2. 遍历 items:
                for (FileItem item : items) {
                    // 若是一个一般的表单域, 打印信息
                    if (item.isFormField()) {
                        String name = item.getFieldName();
                        String value = item.getString("utf-8");

                        System.out.println(name + ": " + value);

                        map.put(name, value);

                    }// 若是文件域则把文件保存到 e:\\files 目录下.
                    else {
                        String fileName = item.getName();
                        long sizeInBytes = item.getSize();
                        System.out.println(fileName);
                        System.out.println(sizeInBytes);

                        InputStream in = item.getInputStream();
                        byte[] buffer = new byte[1024];
                        int len = 0;

                        fileName = "D:\\ideaFile\\Y2Projects\\blogs\\src\\main\\webapp\\WEB-INF\\upload\\" + fileName;//文件最终上传的位置
                        System.out.println(fileName);
                        OutputStream out = new FileOutputStream(fileName);

                        while ((len = in.read(buffer)) != -1) {
                            out.write(buffer, 0, len);
                        }

                        out.close();
                        in.close();
                    }


                }

            } catch (FileUploadException e) {
                e.printStackTrace();
            }


            for (Object key : map.keySet()) {
                System.out.println(key);
                System.out.println(map.get(key));
            }


            String tempBlogId = request.getParameter("blogId");


            String athor = request.getParameter("blogAuthor");

            String Address = request.getParameter("blogAddress");

            String Image = request.getParameter("blogImage");


            System.out.println(tempBlogId + "======" + athor + "======" + Address + "=====" + Image);

            List<blogInfo> list = dao.GetOnePageData(page.getPageIndex(), page.getPageSize());
            System.out.println("list" + list.size());
            page.setList(list);
            //request.setAttribute("list", list);
            request.setAttribute("page", page);
            request.getRequestDispatcher("BlogHtTemplate-master/html/bloglist.jsp").forward(request, response);


        }
    }
}
