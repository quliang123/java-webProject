package controllerViewResolver;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 123 on 2017/08/14.
 */

public class ViewResolverController extends MultiActionController {

   //外部视图
    public ModelAndView doSuccess(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("jd");
        return mv;
    }

      //内部视图
    public ModelAndView doInside(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("jstlView");
        return mv;
    }
}
