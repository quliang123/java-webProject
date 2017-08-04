import com.erma.dao.UserMapper;
import com.erma.model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 123 on 2017/08/02.
 */

public class Test1 {
    @Test
    public void test01() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext-mybatis.xml");

        UserMapper mapper = (UserMapper) ctx.getBean("userMapper");
       User user =  mapper.selectByPrimaryKey(1);
        System.out.println(user);
    }
}
