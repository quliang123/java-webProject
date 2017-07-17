import dao.IBlogsDAO;
import dao.IUserInfoDAO;
import model.Page;
import model.blogInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.MybatisUtil;

import java.util.List;

/**
 * Created by 123 on 2017/07/06.
 */
public class MyUserTest {
    SqlSession sqlSession;
    IBlogsDAO dao;

    @Before    //在单测执行之前，会执行这个方法
    public void before() {
        sqlSession = MybatisUtil.getSqlSession();
        dao = sqlSession.getMapper(IBlogsDAO.class);
    }

    @After    //无论哪个单测过了之后，就会执行的
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void TestGetAllBlog() {
        List<blogInfo> list = dao.GetAllBlogs();
        for (blogInfo item : list) {
            System.out.println(item.getBlogAuthor());
        }
    }

    @Test
    public void TestGetCount() {
        int count = dao.getCount();
        System.out.println(count);
    }


    @Test
    public void TestGetOnePageData() {
        Page page = new Page();
        page.setPageIndex(0);
        page.setPageSize(2);
        List<blogInfo> list = dao.GetOnePageData(0, 10);
        System.out.println(list.size());
        for (blogInfo item : list) {
            System.out.println(item.getBlogAuthor());
        }
        System.out.println(list);
    }


    @Test
    public void TestDelBlog() {
        boolean flag = dao.delBlog(10);
        System.out.println(flag);
    }

    @Test
    public void TestGetBlogInfo() {
        blogInfo blogInfo = dao.getBlogInfo(1);
        System.out.println(blogInfo.getBlogAddress());
    }

    @Test
    public  void  TestmodifyBlog(){
        blogInfo blog = new blogInfo();
        blog.setBlogId(2);
        blog.setBlogAddress("厉害了");
        blog.setBlogAuthor("我的天哪");

      boolean flag=  dao.modifyBlog(blog);
        System.out.println(flag);
    }
}
