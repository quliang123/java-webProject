package UserTest;

import com.erma.model.Classes;
import com.erma.model.Student;
import com.erma.model.Studentattendance;
import com.erma.model.User;
import com.erma.service.IClassesService;
import com.erma.service.IStudentService;
import com.erma.service.IStudentattendanceService;
import com.erma.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by 123 on 2017/08/09.
 */

public class UserInfoTest {


    ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext-mybatis.xml");

    @Test
    public void Test3() throws ParseException {
        IStudentattendanceService studentService = (IStudentattendanceService) ctx.getBean("studentattendanceService");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


        List<Studentattendance> list = studentService.getAllStusByDate(sdf.parse("2017-08-12"));

        for (Studentattendance item:list ) {
            System.out.println(item.getAttendancetime());
            System.out.println(item.getStudentattendaneid());
           // System.out.println(item.getAttendance());
           /* System.out.println(item.getStudent().getStudentname());*/
            for (Student i:item.getStudents()){
                System.out.println(i.getStudentname());
            }
        }



    }


    @Test
    public void Test2() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String time = sdf.format(new Date());


        System.out.println(time);
        System.out.println(new Date());
        IStudentattendanceService studentattendanceService = (IStudentattendanceService) ctx.getBean("studentattendanceService");
        Studentattendance studentattendance = new Studentattendance();
        studentattendance.setStudentattendaneid(1);
        studentattendance.setAttendancetime(new Date());
        studentattendance.setStudentid(1);

        studentattendanceService.save(studentattendance);


    }


    @Test
    public void Test1() {
        IStudentService studentService = (IStudentService) ctx.getBean("studentService");
        List<Student> list = studentService.getStusById("y2164");
        System.out.println(list);
        for (Student item : list) {
            System.out.println(item.getStudentname());
        }
    }


    @Test
    public void Test0() {
        IClassesService classesService = (IClassesService) ctx.getBean("classesService");
        for (Classes classes : classesService.AllClass()) {
            System.out.println(classes.getClassesanem());
        }
        ;
    }


    @Test
    public void isLogin() {
        IUserService userService = (IUserService) ctx.getBean("userService");
        User user = new User();
        user.setLogincode("123");
        user.setLoginpassword("123");

        int count = userService.isLogin(user);
        System.out.println(count);
    }


}
