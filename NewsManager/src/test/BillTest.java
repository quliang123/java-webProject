
import cn.ql.dao.INewsDAO;
import cn.ql.model.Page;
import cn.ql.model.news;
import cn.ql.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 123 on 2017/07/14.
 */
public class BillTest {
    SqlSession sqlSession;
    INewsDAO dao;

    @Before    //在单测执行之前，会执行这个方法
    public void before() {
        sqlSession = MybatisUtil.getSqlSession();
        dao = sqlSession.getMapper(INewsDAO.class);
    }

    @After    //无论哪个单测过了之后，就会执行的
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void TestgetCount() {
        int count = dao.getCount();
        System.out.println(count);
    }


    @Test
    public void TestgetOnePageData() {
        Page page = new Page();
        page.setPageIndex(0);
        page.setPageSize(3);

        List<news> data = dao.getOnePageData(page);

        for (news item : data) {
            System.out.println(item.getNewstitle());
        }
    }


}
