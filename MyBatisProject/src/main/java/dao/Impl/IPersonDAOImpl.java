package dao.Impl;

import dao.IPersonDAO;
import model.Person;
import org.apache.ibatis.session.SqlSession;
import utils.MybatisUtil;

import javax.persistence.criteria.Predicate;
import java.util.List;

/**
 * Created by 123 on 2017/06/30.
 */
public class IPersonDAOImpl implements IPersonDAO {
    SqlSession sqlSession= MybatisUtil.getSqlSession();
    @Override
    public List<Person> getAllPerson() {
        return null;
    }

    @Override
    public boolean updatePerson(Person person) {
        boolean flag=false;
        try {
            int result= sqlSession.update("updatePerson");
            sqlSession.commit();
            flag=true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
             MybatisUtil.closeSession(sqlSession);
        }
        return flag;
    }

    @Override
    public boolean delPerson(int id) {
        boolean flag=false;

        try {
            int result= sqlSession.delete("delPerson",id);
            sqlSession.commit();
            flag=true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }

        return flag;
    }

    @Override
    public List<Person> searchPerson(String name) {
        List<Person> list=null;
        try {
            list= sqlSession.selectList("searchPerson",name);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }
        return list;
    }
}
