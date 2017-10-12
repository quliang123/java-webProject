package annoException.FirstController;

import annoException.AgeException;
import annoException.NameException;
import org.omg.CORBA.UserException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 123 on 2017/08/28.
 */
@Controller
public class FirstController {

    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception ex) {
        ModelAndView mv = new ModelAndView();
        if (ex instanceof AgeException) {
            mv.setViewName("error/Error.jsp");
        }

        if (ex instanceof NameException) {
            mv.setViewName("error/Error.jsp");
        }
        return mv;
    }


    @RequestMapping("/annotationException")
    public String doFirst(UserInfo info) throws Exception {

        if (!info.getName().equals("admin")) {
            //不是admin，抛出一个Name出错异常
            throw new NameException("名称异常");
        }

        if (info.getAge()>60) {
            throw new AgeException("年龄异常");
        }

        return "/index.jsp";
    }
}
