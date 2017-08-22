package AjaxController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by 123 on 2017/08/14.
 */
@Controller
public class ajaxAction extends org.springframework.web.servlet.mvc.multiaction.MultiActionController {

    @RequestMapping("/ajax")
    public void doFirst(HttpServletResponse response) throws Exception {
     response.getWriter().write("ajax");
    }
}
