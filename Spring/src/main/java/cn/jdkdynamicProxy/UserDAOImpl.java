package cn.jdkdynamicProxy;/**
 * Created by 123 on 2017/07/30.
 */

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/30
 * \* Time: 16:00
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class UserDAOImpl implements IUserDAO {
    @Override
    public void add() {
        System.out.println("add success!");
    }
}
