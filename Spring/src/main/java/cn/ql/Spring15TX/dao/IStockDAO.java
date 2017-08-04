package cn.ql.Spring15TX.dao;


import cn.ql.Spring15TX.entity.Stock;

/**
 * Created by Happy on 2017-08-04.
 */
public interface IStockDAO {
    public boolean addStock(Stock stock);
    public boolean updateStock(int sid, int count, boolean isBuy);
}
