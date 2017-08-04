package cn.ql.Spring13AspectjXml.aop;/**
 * Created by 123 on 2017/07/31.
 */

import org.aspectj.lang.JoinPoint;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/31
 * \* Time: 15:07
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class MyBeforeAdvice{

    public void before() throws Throwable {
        System.out.println("之前===========================");
    }

    public void after(JoinPoint jp,Object result){
        System.out.println("之后===========================");
    }

}
