package cn.ql.Spring15TX.service;

import cn.ql.Spring15TX.entity.StockException;

/**
 * Created by 123 on 2017/08/04.
 */
public interface IAccountService {

    public void buyStock(int sid, int count, int aid, double money) throws StockException;
}
