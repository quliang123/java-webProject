package cn.ql.spring03;/**
 * Created by 123 on 2017/07/24.
 */

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/24
 * \* Time: 10:42
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Print {
    //植入两个复杂类型的对象
    private Ink ink;
    private Paper paper;

    public Ink getInk() {
        return ink;
    }

    public void setInk(Ink ink) {
        this.ink = ink;
    }


    //因为方便我获取颜色和类型纸张,所以直接就调用了复杂类型的get方法
    @Override
    public String toString() {
        return "Print{" +
                "ink=" + ink.getColor() +
                ", paper=" + paper.getPage() +
                '}';
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }
}
