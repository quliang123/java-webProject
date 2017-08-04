package cn.ql.Spring12Aspectj.aop;/**
 * Created by 123 on 2017/07/31.
 */

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/31
 * \* Time: 15:07
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class MyBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("之前===========================");
    }
}
