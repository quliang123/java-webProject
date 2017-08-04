package cn.ql.Spring15TX.service;

import cn.ql.Spring15TX.dao.IAccountDAO;
import cn.ql.Spring15TX.dao.IStockDAO;
import cn.ql.Spring15TX.entity.StockException;

/**
 * Created by 123 on 2017/08/04.
 */

public class AccountServiceImpl implements IAccountService {
    public IAccountDAO getAccountDAO() {
        return accountDAO;
    }

    public void setAccountDAO(IAccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    private IAccountDAO accountDAO;

    private IStockDAO stockDAO;

    public IStockDAO getStockDAO() {
        return stockDAO;
    }

    public void setStockDAO(IStockDAO stockDAO) {
        this.stockDAO = stockDAO;
    }





    @Override
    public void buyStock(int sid, int count, int aid, double money) throws StockException {
        boolean isBuy = true;
        accountDAO.updateAccount(aid, money, isBuy);


        if (1==1){
            throw new StockException("出错了");
        }
        stockDAO.updateStock(sid, count, isBuy);

    }
}
