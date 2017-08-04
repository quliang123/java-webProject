package cn.ql.spring08.aop;/**
 * Created by 123 on 2017/07/31.
 */

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.ThrowsAdvice;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/31
 * \* Time: 15:07
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class MyExceptionAdvice implements ThrowsAdvice {

    public void afterThrowing(Exception ex) {
        System.out.println("我是增强中的异常" + ex.getMessage());
    }

}
