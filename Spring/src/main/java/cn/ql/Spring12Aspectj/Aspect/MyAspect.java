package cn.ql.Spring12Aspectj.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by 123 on 2017/08/02.
 */

@Aspect
public class MyAspect {

    @Pointcut("execution(* *..Spring12Aspectj.*.*.Sing(..))")
    public void Sing() { }

    @Pointcut("execution(* *..Spring12Aspectj.*.*.look(..))")
    public void look() { }

    @Pointcut("execution(* *..Spring12Aspectj.*.*.Say(..))")
    public void Say() { }



    @Before("Sing() || look() || Say()")
    public void before() {
        System.out.println("==================before==================");
    }


}
