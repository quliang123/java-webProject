package cn.ql.spring01;/**
 * Created by 123 on 2017/07/24.
 */

import cn.ql.spring05dixml.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/24
 * \* Time: 09:31
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class TestCarAndStudentDixml {
    @Test
    public void TestCarAndStudent() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextDixml.xml");
        Student stu = (Student) ctx.getBean("stu");
        System.out.println(stu);
    }
}
