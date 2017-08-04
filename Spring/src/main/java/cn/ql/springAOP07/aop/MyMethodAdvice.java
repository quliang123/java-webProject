package cn.ql.springAOP07.aop;/**
 * Created by 123 on 2017/07/31.
 */

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/31
 * \* Time: 15:07
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class MyMethodAdvice implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("之前");

        Object result = methodInvocation.proceed();

        String temp = null;
        if (result != null) {
            temp = (String) result;
            temp = temp.toUpperCase();
        }

        System.out.println("之后");
        return temp;
    }
}
