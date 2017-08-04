package cn.ql.spring01;/**
 * Created by 123 on 2017/07/24.
 */

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
public class TestSomeService {

    @Test
    public void TestSomeService() {
        /**
         * scope
         * singleton   单列的
         *prototype 多例的
         */

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*SomeService someService = (SomeService)ctx.getBean("someService");

        someService.setInfo("spring");

        someService.work();*/
    }
}
