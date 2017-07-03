import dao.StudentDao;
import model.Dog;
import model.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.MybatisUtil;

import java.util.List;

/**
 * Created by 123 on 2017/07/03.
 *因为重写了toString()方法，所以可以直接打印出来数据
 */
public class MyTest {
    SqlSession sqlSession;
    StudentDao dao;

    @Before    //在单测执行之前，会执行这个方法
    public void before() {
        sqlSession = MybatisUtil.getSqlSession();
        dao = sqlSession.getMapper(StudentDao.class);
    }

    @After    //无论哪个单测过了之后，就会执行的
    public void after() {
        sqlSession.commit();
        sqlSession.close();
    }

   /* @Test       //查看所有的学生
    public void TestGetStus() {
        List<Student> list = dao.getStu();
        for (Student item : list) {
            System.out.println(item.getName());
        }
    }*/

  /*  @Test    //按姓名模糊查询学生对象
    public void TestLikeName() {
        List<Student> list = dao.likeName("郭");
        System.out.println(list);
    }*/

    /*@Test  //同一id之下的宠物
    public void TestGetDog() {
       List<Dog> list= dao.getDog();
        System.out.println(list);

    }*/


}
