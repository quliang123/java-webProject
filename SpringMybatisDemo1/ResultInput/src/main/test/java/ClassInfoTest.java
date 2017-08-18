import com.erma.dao.ClassInfoMapper;
import com.erma.model.Class_info;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 123 on 2017/08/09.
 */

public class ClassInfoTest {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext-mybatis.xml");


    @Test
    public void Test1() {
        ClassInfoMapper classInfoService = (ClassInfoMapper) ctx.getBean("classService");
        for (Class_info item : classInfoService.getAllData()) {
            System.out.println(item.getCname());
        };
    }


    @Test
    public void Test0() {

        ClassInfoMapper classInfoService = (ClassInfoMapper) ctx.getBean("classService");
        int id = classInfoService.saveClass("y2167");
        System.out.println(id);
    }
}
