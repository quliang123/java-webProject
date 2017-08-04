package cn.ql.Spring12Aspectj.dao;/**
 * Created by 123 on 2017/07/31.
 */

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/31
 * \* Time: 15:05
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class SomeServiceImpl implements ISomeService {
    @Override
    public void Run() {
        System.out.println("厉害了,我等  Run");
    }

    @Override
    public void Sing() {
        System.out.println("她骚  Sing");
    }

    @Override
    public void look() {
        System.out.println("我看来看去  look");
    }

    @Override
    public void Say() {
        System.out.println("hello baby  Say");
    }
}
