package cn.jdkProxy;/**
 * Created by 123 on 2017/07/30.
 */

import cn.jdkdynamicProxy.IService;
import cn.jdkdynamicProxy.IUserDAO;
import cn.jdkdynamicProxy.ServicImpl;
import cn.jdkdynamicProxy.UserDAOImpl;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/30
 * \* Time: 16:01
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class jdkTest {
    @Test
    public void service() {
        IService service = new ServicImpl();

        IService proxy = (IService) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before==============");
                method.invoke(service, args);
                System.out.println("after===============");
                return null;
            }
        });
        proxy.run();
    }


    @Test
    public void testJDK() {
        final IUserDAO service = new UserDAOImpl();

        InvocationHandler ih = new InvocationHandler() {
            /**
             *
             * @param proxy       代理对象
             * @param method     被代理对象的方法
             * @param args        被代理对象参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before===========");
                Object result = method.invoke(service, args);
                System.out.println("after============");
                return result;
            }
        };


        IUserDAO proxy = (IUserDAO) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), ih);

        proxy.add();
    }

}
