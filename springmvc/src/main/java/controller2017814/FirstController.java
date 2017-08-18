package controller2017814;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 123 on 2017/08/14.
 */

public class FirstController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        ModelAndView mv = new ModelAndView();
        //物理视图的名称,因为在在springmvc012017-8-14.xml中配置了前缀和后缀,所以只需要一个物理视图的名称
        mv.setViewName("index");
        //可以用addObject携带数据到物理视图上,用el表达式来获取数据
        mv.addObject("uname", "我靠");

        return mv;
    }
}
