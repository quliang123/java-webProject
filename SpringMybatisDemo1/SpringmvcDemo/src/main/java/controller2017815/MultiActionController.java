package controller2017815;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 123 on 2017/08/14.
 */

public class MultiActionController extends org.springframework.web.servlet.mvc.multiaction.MultiActionController{


    public ModelAndView doSuccess(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    public ModelAndView doFiler(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index2");
        return mv;
    }
}
