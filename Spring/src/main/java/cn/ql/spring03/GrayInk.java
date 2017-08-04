package cn.ql.spring03;/**
 * Created by 123 on 2017/07/24.
 */

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/24
 * \* Time: 10:36
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
////墨水的实现类    灰色墨水
public class GrayInk implements Ink {
    @Override
    public String getColor() {
        return "灰色";
    }
}
