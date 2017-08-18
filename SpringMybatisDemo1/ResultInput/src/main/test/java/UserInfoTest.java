import com.erma.model.UserInfo;
import com.erma.service.IUserInfoService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 123 on 2017/08/09.
 */

public class UserInfoTest {


    ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext-mybatis.xml");

    @Test
    public void isLogin() {

        IUserInfoService userInfoService = (IUserInfoService) ctx.getBean("userService");

        UserInfo user = new UserInfo();
        user.setUsername("123");
        user.setUserpwd("123");
        int count = userInfoService.isLogin(user);
        System.out.println(count);
    }



}
