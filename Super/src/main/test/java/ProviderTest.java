import cn.ql.dao.IBillDAO;
import cn.ql.dao.IProviderDAO;
import cn.ql.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by 123 on 2017/07/20.
 */
public class ProviderTest {
    SqlSession sqlSession;
    IProviderDAO dao;

    @Before    //在单测执行之前，会执行这个方法
    public void before() {
        sqlSession = MybatisUtil.getSqlSession();
        dao = sqlSession.getMapper(IProviderDAO.class);
    }

    @After    //无论哪个单测过了之后，就会执行的
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void TestsearchNameById(){
        String s = dao.searchNameById(1);
        System.out.println(s);
    }
}
