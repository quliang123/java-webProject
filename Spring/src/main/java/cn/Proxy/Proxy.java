package cn.Proxy;/**
 * Created by 123 on 2017/07/30.
 */

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/30
 * \* Time: 15:48
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Proxy implements Subject {
    private RealSubject rs;

    @Override
    public void service() {

        if (rs == null) {
            rs = new RealSubject();
        }

        System.out.println("before=====");
        rs.service();
        System.out.println("after======");
    }
}
