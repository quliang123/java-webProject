package cn.Proxy;/**
 * Created by 123 on 2017/07/30.
 */

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/30
 * \* Time: 15:46
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class RealSubject implements Subject {
    @Override
    public void service() {
        System.out.println("service");
    }
}
