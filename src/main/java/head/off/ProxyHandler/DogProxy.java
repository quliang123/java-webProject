package head.off.ProxyHandler;

import head.off.interceptor.DogIntercepter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by 123 on 2017/06/22.
 */
public class DogProxy implements InvocationHandler {

    private  Object target;
    DogIntercepter dog=new DogIntercepter();

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
          Object result=null;

          //每次在测试类型TestDog中，调用一次实现类中的方法时，都会进入这个方法
          if (method.getName().equals("info")){    //如果方法是info
              System.out.println("第三执行");
              dog.method1();
              result=method.invoke(target,args);     //在此处已经调用info方法中的实现了
              System.out.println("第四执行");
              dog.method2();
          }else {                       //不是的话
              System.out.println("第五执行");
              result=method.invoke(target,args);
          }
          System.out.println("第六执行");
        return result;
    }

    public void  setTarget(Object obj){     //赋值的方法只会走一次
        System.out.println("第000执行");
        this.target=obj;
    }
}
