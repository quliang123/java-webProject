package cn.ql.spring03;/**
 * Created by 123 on 2017/07/24.
 */

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/24
 * \* Time: 10:40
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
//纸张的实现类    B5纸张
public class B5Paper implements Paper {
    @Override
    public String getPage() {
        return "我是一张B5纸";
    }
}
