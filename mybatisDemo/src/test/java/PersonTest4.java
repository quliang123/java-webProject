import dao.IPersonDAO;
import dao.IShoopDAO;
import dao.ISonDAO;
import model.Category;
import model.Person;
import model.Son;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MybatisUtil;

import java.util.List;

/**
 * Created by 123 on 2017/06/29.
 */
public class PersonTest4 {
    ISonDAO dao;
    SqlSession sqlSession;

    @Test
    public void TestFindSonById() {
        sqlSession = MybatisUtil.getSqlSession();
        dao = sqlSession.getMapper(ISonDAO.class);
        System.out.println("===================");
        Son son = dao.findSonById(2);
        System.out.println(son);

    }


    @Test
    public void TestGetChilderByPid() {
        sqlSession = MybatisUtil.getSqlSession();
        IShoopDAO dao = sqlSession.getMapper(IShoopDAO.class);
        List<Category> list = dao.getChilderByPid(1);
        System.out.println(list.toString());
    }
}


