import model.Person;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MybatisUtil;
/**
 * Created by 123 on 2017/06/29.
 */
public class PersonTest {
    SqlSession sqlSession ;
        @Test
       public  void  insertPerson(){
            sqlSession = MybatisUtil.getSqlSession();
            Person person=new Person();
            person.setId(1);
            person.setAge(18);
            person.setMobilePhone("1361165680");
            person.setUserName("神奇");
            try {
                sqlSession.insert("insertPerson",person);
                sqlSession.commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                MybatisUtil.closeSession(sqlSession);
            }
        }


        @Test
       public  void queryById(){
            sqlSession=MybatisUtil.getSqlSession();

            try {
                Person person =sqlSession.selectOne("queryById",1);
                sqlSession.commit();
                System.out.println(person.getUserName());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                MybatisUtil.closeSession(sqlSession);
            }

        }


}
