package cn.ql.springTX;

import cn.ql.Spring15TX.entity.StockException;
import cn.ql.Spring15TX.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 123 on 2017/08/04.
 */

public class TestTX {

    @Test
    public void TestTX() throws StockException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextTX.xml");
        IAccountService service = (IAccountService) ctx.getBean("accountServiceProxy");
        service.buyStock(1,2,1,2000);
    }
}
