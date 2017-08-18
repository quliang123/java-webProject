package cn.cglibPoxy;/**
 * Created by 123 on 2017/07/31.
 */

import cn.cglibProxy.someServiceCGLIB;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/31
 * \* Time: 14:32
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class testSomeCglib {
    /**
     * cglib动态代理
     */
    @Test
    public void TestCglib() {

        someServiceCGLIB service = new
                someServiceCGLIB();

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(service.getClass());

        enhancer.setCallback(new MethodInterceptor() {
            /**
             *
             * @param o             代理对象
             * @param method        被代理对象的方法
             * @param objects       被代理对象那参数
             * @param methodProxy   代理对象方法
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("春天的春=================");
                methodProxy.invoke(service, objects);
                return null;
            }
        });

        someServiceCGLIB proxy = (someServiceCGLIB)enhancer.create();
        proxy.run();

    }
}
