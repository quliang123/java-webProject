package dao;

import model.Dog;
import model.Student;

import java.util.List;

/**
 * Created by 123 on 2017/07/03.
 */
public interface StudentDao {
    //查看所有的学生
    public List<Student> getStu();

    //按姓名模糊查询学生对象
    public List<Student> likeName(String name);

    //获取获取同一id的宠物
     public  List<Dog> getDog();

}
