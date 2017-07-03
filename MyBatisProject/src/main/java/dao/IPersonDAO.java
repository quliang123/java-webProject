package dao;

import model.Person;

import java.util.List;
import java.util.Map;

/**
 * Created by 123 on 2017/06/30.
 */
public interface IPersonDAO {
    public List<Person> getAllPerson();

    public boolean updatePerson(Person person);

    public boolean delPerson(int id);

    public List<Person> searchPerson(Person person);

    public List<Person> findPersonByCondition(Map<String,Object>map);

    public  List<Person> findPersonByCondition(String names);
}
