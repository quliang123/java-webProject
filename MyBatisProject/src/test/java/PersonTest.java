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
public class PersonTest {
    IPersonDAO dao;
    SqlSession sqlSession;
    @Test
    public  void  TestUpdate(){
        try {
            sqlSession=MybatisUtil.getSqlSession();

            Person person=new Person();
            person.setId(2);
            person.setAge(19);
           /* person.setMobilePhone("13691165680");
            person.setUsername("fuck");*/

            int count=sqlSession.update("updatePerson",person);
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
    public  void  findPersonByCondition(){
        sqlSession= MybatisUtil.getSqlSession();

        try {
            List<Person> f = sqlSession.getMapper(IPersonDAO.class).findPersonByCondition("f");
                  /*  .getMapper(IPersonDAO.class).findPersonByCondition("f");*/
            System.out.println(f.size());

            System.out.println("成功");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }

    }




    @Test
    public  void  TestSearch() {
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

    }


