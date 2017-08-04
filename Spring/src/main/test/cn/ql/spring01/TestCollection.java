package cn.ql.spring01;/**
 * Created by 123 on 2017/07/24.
 */

import cn.ql.spring05dixml.Student;
import cn.ql.spring06Collection.MyCollection;
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
public class TestCollection {

    @Test
    public void TestCarAndStudent() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextCollection.xml");
        MyCollection arr = (MyCollection) ctx.getBean("arr");
        System.out.println(arr);

        MyCollection list = (MyCollection) ctx.getBean("list");
        System.out.println(list);

        MyCollection set = (MyCollection) ctx.getBean("set");
        System.out.println(set);

        MyCollection map = (MyCollection) ctx.getBean("map");
        System.out.println(map);

        MyCollection properties = (MyCollection) ctx.getBean("properties");
        System.out.println(properties);
    }
}
