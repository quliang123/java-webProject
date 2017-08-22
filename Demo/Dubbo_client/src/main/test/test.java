import api.SayHello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 123 on 2017/08/21.
 */

public class test {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SayHello sayHello = (SayHello) ctx.getBean("sayHelloService");
        String hi = sayHello.sayHello("dog 华");
        System.out.println(hi);
    }
}
