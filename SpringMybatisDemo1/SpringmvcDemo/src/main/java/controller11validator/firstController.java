package controller11validator;

import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by 123 on 2017/08/30.
 */
@Controller
public class firstController extends PropertiesEditor {

    @RequestMapping(value = "/first")
    public ModelAndView doFirst(@Valid UserInfo userInfo, BindingResult br) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/1.jsp");
        int errorCount = br.getErrorCount();
        if (errorCount > 0) {
            FieldError score = br.getFieldError("score");
            FieldError name = br.getFieldError("name");
            FieldError phone = br.getFieldError("phone");
            if (score != null) {
                mv.addObject("scoremsg", score.getDefaultMessage());
            }
            if (name != null) {
                mv.addObject("namemsg",name.getDefaultMessage());
            }
            if (phone != null) {
                mv.addObject("phonemsg",name.getDefaultMessage());
            }
            mv.setViewName("/3.jsp");
        }
        return mv;
    }
}
