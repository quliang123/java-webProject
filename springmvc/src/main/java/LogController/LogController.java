package LogController;

import log.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 123 on 2017/08/14.
 */
@Controller
public class LogController {

     @Log(desc = "测试系统日志跟踪",operationDesc = "测试")
    @RequestMapping(value = "/hello")
    public String Log() throws Exception {
        System.out.println("log");
        return "/index3.jsp";
    }

}
