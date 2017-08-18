package cn.ql.springAOP;

import cn.ql.spring14jdbc.entity.Book;
import cn.ql.spring14jdbc.servcie.IBookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 123 on 2017/08/02.
 */

public class Test02 {

    @Test
    public void test09() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextJDBC.xml");
        IBookService service = (IBookService) ctx.getBean("bookService");
        for (Book book : service.findAll()) {
            System.out.println(book.getBooName());
        }
    }


    @Test
    public void test08() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextAOP04.xml");
        cn.ql.Spring13AspectjXml.dao.ISomeService service = (cn.ql.Spring13AspectjXml.dao.ISomeService) ctx.getBean("someService");
        service.Run();
        service.Say();
        service.look();
        service.Sing();
    }
}
