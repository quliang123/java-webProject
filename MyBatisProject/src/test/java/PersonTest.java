import dao.Impl.IPersonDAOImpl;
import model.Person;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import sun.security.pkcs11.Secmod;
import utils.MybatisUtil;

import javax.jms.Session;
import java.util.List;

/**
 * Created by 123 on 2017/06/29.
 */
public class PersonTest {
    SqlSession sqlSession;
IPersonDAOImpl Impl=new IPersonDAOImpl();
    @Test
    public void insertPerson() {
        sqlSession = MybatisUtil.getSqlSession();
        Person person = new Person();
        person.setId(1);
        person.setAge(18);
        person.setMobilePhone("1361165680");
        person.setUserName("神奇");
        try {
            sqlSession.insert("insertPerson", person);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }
    }


    @Test
    public void queryById() {
        sqlSession = MybatisUtil.getSqlSession();
        try {
            Person person = sqlSession.selectOne("queryById", 1);
            sqlSession.commit();
            System.out.println(person.getUserName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }
    }

    @Test
    public void TestGetAll() {
        sqlSession = MybatisUtil.getSqlSession();
        try {
            List<Person> list = sqlSession.selectList("selectAll");
            System.out.println(list.size());
            for (Person item :list) {
                System.out.println(item.getUserName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }
    }

    @Test
    public void TestUpdate(){
   Person person=new Person();
   person.setUserName("123");
   person.setMobilePhone("13691165680");
   person.setAge(18);
   person.setId(1);
   boolean flag=  Impl.updatePerson(person);
        System.out.println(flag);
    }


    @Test
    public void delPerson(){
           boolean flag= Impl.delPerson(1);
        System.out.println(flag);
    }

    @Test
    public  void  SearchPerson(){
        List<Person> list= Impl.searchPerson("123");
        for (Person item:list) {
            System.out.println(item.getUserName());
        }
    }


}
