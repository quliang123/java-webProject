package ParametMerthodNameResolverController;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 123 on 2017/08/14.
 */

public class ParametMerthodNameResolverController extends MultiActionController {


    public ModelAndView doSuccess(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

}
