package ControllerInterceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 123 on 2017/09/04.
 */
@Controller
public class FirstController {

    @RequestMapping(value = "/first")
    public String doFirst() {
        System.out.println("handler==============");
        return "/1.jsp";
    }
}
