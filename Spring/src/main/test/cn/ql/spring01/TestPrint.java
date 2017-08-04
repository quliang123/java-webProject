package cn.ql.spring01;/**
 * Created by 123 on 2017/07/24.
 */

import cn.ql.spring03.Print;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.AppletContext;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/24
 * \* Time: 11:35
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class TestPrint {

    @Test
    public void Testprint() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Print print = (Print) ctx.getBean("print");
        //其实在这里调用也是没啥问题的
        System.out.println(print);
    }
}
