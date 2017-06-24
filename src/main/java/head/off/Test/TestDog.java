package head.off.Test;

import head.off.ProxyHandler.DogProxy;
import head.off.dao.Dog;
import head.off.dao.impl.DogImpl;

import java.lang.reflect.Proxy;

/**
 * Created by 123 on 2017/06/22.
 * @author 123
 * 测试类
 */
public class TestDog {
    public static void main(String[] args) {
        Dog targetObject = new DogImpl();    //目标对象

        Dog dog = null;

        DogProxy handler = new DogProxy();

        //赋值给handler那边的私有变量
        handler.setTarget(targetObject);
        /**
         * 第一个参数是用来创建动态代理的classloader对象，只要该对象能访问接口
         *第二个参数是接口数组，正是代理该接口的数组
         * 第三个参数是代理包含的处理实例
         */
        System.out.println("第十一执行");
        Object proxy = Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), handler);

        System.out.println(proxy);

        if (proxy instanceof Dog) {
            dog = (Dog) proxy;    //代理对象实际上也实现了接口Dog
        }

        System.out.println("第九执行");

        dog.info();     //因为满足拦截器的条件，所以被迫执行了拦截器中的方法，但重要的是并没有执行此方法，

        System.out.println("第十执行");

        dog.run();
    }
}