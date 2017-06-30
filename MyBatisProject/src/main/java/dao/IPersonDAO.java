package dao;

import model.Person;

import java.util.List;

/**
 * Created by 123 on 2017/06/30.
 */
public interface IPersonDAO {
    public List<Person>  getAllPerson();
    public  boolean updatePerson(Person person);
    public  boolean delPerson(int id);
    public  List<Person> searchPerson(String name);
}
