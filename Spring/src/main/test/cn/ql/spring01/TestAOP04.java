package cn.ql.spring01;/**
 * Created by 123 on 2017/07/24.
 */

        import cn.ql.springAOP04.entity.User;
import cn.ql.springAOP04.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/24
 * \* Time: 12:28
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class TestAOP04 {
    @Test
    public void testAOP04() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextAop.xml");
        IUserService service = (IUserService) ctx.getBean("userService");
        User user = new User();
        service.save(user);
    }
}
