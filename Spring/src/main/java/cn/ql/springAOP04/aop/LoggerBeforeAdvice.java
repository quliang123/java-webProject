package cn.ql.springAOP04.aop;/**
 * Created by 123 on 2017/07/24.
 */

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/24
 * \* Time: 12:11
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
//前置增强类
public class LoggerBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("========================记录日志");
    }
}
