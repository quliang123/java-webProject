import dao.IPersonDAO;
import model.Person;
import model.Son;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MybatisUtil;

import java.util.List;

/**
 * Created by 123 on 2017/06/29.
 */
public class PersonTest3 {
    IPersonDAO dao;
    SqlSession sqlSession;


    @Test
    public void TestfindSonByNoMultipleSQL() {
        sqlSession = MybatisUtil.getSqlSession();
        dao = sqlSession.getMapper(IPersonDAO.class);
        Person person = dao.findSonByNoMultipleSQL(2);
       //System.out.println(person.getUserName());
    }


    @Test
    public void TestfindSonByNo() {
        sqlSession = MybatisUtil.getSqlSession();
        dao = sqlSession.getMapper(IPersonDAO.class);
        Person person = dao.findSonByNo(2);

        for (Son item : person.getSons()) {
            System.out.println(item.getName());
        }
    }
}


