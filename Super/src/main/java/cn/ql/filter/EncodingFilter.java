package cn.ql.filter;

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
        characterEncoding = config.getInitParameter("characterEncoding");  //在web.xml中配置好的UTF-8
        enabled = "true".equalsIgnoreCase(config.getInitParameter("enabled"));//是否启用  
        System.out.println("设置好编码了");
    }


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //设置字符编码
        if (enabled && characterEncoding != null) {
            request.setCharacterEncoding(characterEncoding);
            response.setCharacterEncoding(characterEncoding);
        }
        chain.doFilter(request, response);
    }


    //销毁方法
    public void destroy() {
        characterEncoding = null;
        System.out.println("已销毁。。。");
    }


}
