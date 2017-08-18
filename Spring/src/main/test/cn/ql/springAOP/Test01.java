package cn.ql.springAOP;/**
 * Created by 123 on 2017/07/31.
 */

import cn.ql.springAOP05.dao.ISomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/31
 * \* Time: 15:12
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Test01 {

    @Test
    public void test08() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextAOP02.xml");
        cn.ql.Spring12Aspectj.dao.ISomeService service = (cn.ql.Spring12Aspectj.dao.ISomeService) ctx.getBean("someService");
        service.Run();
        service.Say();
        service.look();
        service.Sing();
    }


    @Test
    public void test07() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextAOP01.xml");
        cn.ql.Spring11.dao.ISomeService service = (cn.ql.Spring11.dao.ISomeService) ctx.getBean("RegxpProxy");
        service.Run();
        service.Say();
        service.look();
        service.Sing();
    }


    @Test
    public void test06() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextAop01.xml");
        cn.ql.Spring10Regxp.dao.ISomeService service = (cn.ql.Spring10Regxp.dao.ISomeService) ctx.getBean("RegxpProxy");
        service.Run();
        service.Say();
        service.look();
        service.Sing();
    }

    @Test
    public void test05() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextAop01.xml");
        cn.ql.Spring09Advisor.dao.ISomeService service = (cn.ql.Spring09Advisor.dao.ISomeService) ctx.getBean("AdvisorProxy");
        service.Run();
        service.Say();
    }


    @Test
    public void test04() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextAop01.xml");
        cn.ql.spring08.dao.ISomeService service = (cn.ql.spring08.dao.ISomeService) ctx.getBean("ExceptionProxy");
        service.Run();
    }


    @Test
    public void test03() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextAop01.xml");
        cn.ql.springAOP07.dao.ISomeService service = (cn.ql.springAOP07.dao.ISomeService) ctx.getBean("methodProxy");
        service.Run();
    }


    @Test
    public void test02() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextAop01.xml");
        cn.ql.springAOP06.dao.ISomeService service = (cn.ql.springAOP06.dao.ISomeService) ctx.getBean("someproxy");
        service.Run();
    }

    @Test
    public void test01() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextAop01.xml");
        ISomeService service = (ISomeService) ctx.getBean("someProxy");
        service.Run();
    }

}
