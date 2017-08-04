import dao.IPersonDAO;
import model.Person;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MybatisUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 123 on 2017/06/29.
 */
public class PersonTest2 {
    IPersonDAO dao;
    SqlSession sqlSession;

    @Test
    public void TestUpdate() {
        try {
            sqlSession = MybatisUtil.getSqlSession();

            Person person = new Person();
            person.setId(2);
            person.setAge(19);
           /* person.setMobilePhone("13691165680");
            person.setUsername("fuck");*/

            int count = sqlSession.update("updatePerson", person);
            System.out.println(count);
            sqlSession.commit();   //没有提交事务，所以数据库中的数据也不会改变
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }
    }


    /**
     * 修改
     */
    /*@Test
    public  void  findPersonByCondition(){
        sqlSession= MybatisUtil.getSqlSession();

        try {
            Map<String,Object> map=new HashMap<String, Object>();
            map.put("name", "f");
            if (map==null)return;
            System.out.println("abc");
            System.out.println(dao.findPersonByCondition(map).size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }
              *//* List<Person> list=
           if (list==null){
               System.out.println("null");
           }*//*
       *//* for (Person item:list) {
            System.out.println(item.getUsername());
        }*//*
    }*/
    @Test
    public void findPersonByCondition() {
        sqlSession = MybatisUtil.getSqlSession();

        try {
            //sqlSession.insert();
            List<Person> f = sqlSession.getMapper(IPersonDAO.class).findPersonByCondition("f");
            System.out.println(f.size());
            System.out.println("成功");
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }


    @Test
    public void TestSearch() {
        sqlSession = MybatisUtil.getSqlSession();

        Person person = new Person();
       /* person.setUsername("fuck");
        try {
           List<Person> list= dao.searchPerson(person);
            for (Person item:list) {
                System.out.println(item.getUsername());
            }
            System.out.println();
            System.out.println("成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }
    }*/
    }


    @Test
    public void TestInsertPerson() {
        sqlSession = MybatisUtil.getSqlSession();

        Person person = new Person();
        person.setUserName("123444");
        person.setAge(18);
        person.setMobilePhone("13691165680");

        int count = sqlSession.getMapper(IPersonDAO.class).insertPerson(person);

        sqlSession.commit();
        sqlSession.close();


        System.out.println("Count" + count);
    }


    @Test
    public void TestSelectAll() {
        sqlSession = MybatisUtil.getSqlSession();
        Person person = sqlSession.selectOne("selectAll", 2);
        System.out.println(person.getUserName());
        System.out.println("======================");


        sqlSession.close();

        sqlSession = MybatisUtil.getSqlSession();
        Person person1 = sqlSession.selectOne("selectAll", 2);
        System.out.println(person1.getUserName());

        System.out.println("======================");

        person = sqlSession.selectOne("selectAll", 2);
        System.out.println(person.getUserName());
    }


    @Test
    public void LikePerson() {
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        IPersonDAO dao = sqlSession.getMapper(IPersonDAO.class);
       /* Map<String, Object> map = new HashMap<String, Object>();

        map.put("username", "fuck");
        map.put("age", 19);*/

        List<Person> list=dao.LikePerson("fuck",19);
        System.out.println(list.size());
        for (Person person:list) {
            System.out.println("========="+person.getUserName());
        }
        sqlSession.close();
    }

}


