package controllerannotaion2017170817;

import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by 123 on 2017/08/14.
 */
//注解

@org.springframework.stereotype.Controller
@RequestMapping("/Order")
public class Controller{
   //外部视图      通配符
    @RequestMapping(value = "/*doSuccess")
    public String doSuccess(){
        System.out.println("111");
        return "/index3.jsp";
    }

}
