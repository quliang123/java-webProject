package cn.ql.Spring15TX.entity;

/**
 * Created by Happy on 2017-08-04.
 * StockException 异常
 * 编译时 编译时
 *@author 123
 * 依据：
 *自定义异常
 */
public class StockException extends Exception {
    public StockException() {
        super();
    }

    public StockException(String message) {
        super(message);
    }
}
