package exceptionController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 123 on 2017/08/28.
 */
@Controller
public class ErrorController {
    @RequestMapping(value = "/error")
    public String errorC() {
      int result=5/0;
        return "/WEB-INF/st.jsp";
    }

}
