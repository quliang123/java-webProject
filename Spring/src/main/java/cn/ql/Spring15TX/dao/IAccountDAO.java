package cn.ql.Spring15TX.dao;


/**
 * Created by Happy on 2017-08-04.
 * 账户类
 */
public interface IAccountDAO {

    //修改账户余额  金额减少true
    public boolean updateAccount(int aid, double money, boolean isBuy);
}
