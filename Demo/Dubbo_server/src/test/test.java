import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by 123 on 2017/08/21.
 */

public class test {
    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.in.read();
        System.out.println("按任意键退出");
    }
}
