package converttype;

import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by 123 on 2017/08/28.
 */

@Controller
public class FirsController {
    @ExceptionHandler(TypeMismatchException.class)
    public ModelAndView exceptionHandler(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("date", request.getParameter("birthday"));
        mv.setViewName("typeconverter.jsp");
        return null;
    }

    @RequestMapping("/first")
    public String doFirst(Date birthday, int age) {
        return "index";
    }
}
