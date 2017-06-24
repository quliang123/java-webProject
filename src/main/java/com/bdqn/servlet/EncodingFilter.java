package com.bdqn.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by 123 on 2017/06/22.
 *
 * @author 123
 *         编码过滤器
 */
public class EncodingFilter implements Filter {
    private String characterEncoding;
    private boolean enabled;//是否启用 

    public void init(FilterConfig config) throws ServletException {
        //获取在web.xml配置好的参数
        System.out.println("进入init");
        characterEncoding = config.getInitParameter("characterEncoding");  //在web.xml中配置好的UTF-8
        enabled = "true".equalsIgnoreCase(config.getInitParameter("enabled"));//是否启用  
    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //设置字符编码
        if (enabled && characterEncoding != null) {
            request.setCharacterEncoding(characterEncoding);
            response.setCharacterEncoding(characterEncoding);
        }
        System.out.println("已经设置完编码");
        chain.doFilter(request, response);
    }


    //销毁方法
    public void destroy() {
        System.out.println("销毁");
        characterEncoding = null;
    }


}
