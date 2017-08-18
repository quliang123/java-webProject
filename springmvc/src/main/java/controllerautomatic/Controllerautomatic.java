package controllerautomatic;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by 123 on 2017/08/14.
 */
//注解
@org.springframework.stereotype.Controller
public class Controllerautomatic {
   //外部视图      通配符

   //username必须和表单元素保持一致
    @RequestMapping(value = "/hello")
    public String doSuccess(Model model,String name){
        System.out.println("name======1111"+name);
        return "/index3.jsp";
    }

    //对象
    @RequestMapping(value = "/second")
    public String second(Model model,UserInfo userInfo) {
        System.out.println("user======"+userInfo.getName());
        return "/index3.jsp";
    }

    //域属性
    @RequestMapping(value = "/third")
    public String third(Model model,UserInfo userInfo) {
        System.out.println("user======"+userInfo.getName()+"userinfo"+userInfo.getAddress().getAddress());
        return "/index3.jsp";
    }

    //集合
    @RequestMapping(value = "/arr")
    public String arr(Model model,UserInfo userInfo) {
        System.out.println(userInfo.getList().get(0).getBookName());
        return "/index3.jsp";
    }

    //校正请求参数名
    @RequestMapping(value = "/parameter")
    public String parameter(Model model,@RequestParam(value ="name",required = false) String uamename){
        System.out.println("name======"+uamename);
        return "/index3.jsp";
    }

}
