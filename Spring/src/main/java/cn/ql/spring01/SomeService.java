package cn.ql.spring01; /**
 * Created by 123 on 2017/07/24.
 */

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/24
 * \* Time: 09:26
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class SomeService {
    private String info;

    public SomeService() {
        System.out.println("===============");
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void work() {
        System.out.println("Hello" + info);
    }
}
