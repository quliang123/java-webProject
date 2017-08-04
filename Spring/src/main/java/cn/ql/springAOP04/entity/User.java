package cn.ql.springAOP04.entity;/**
 * Created by 123 on 2017/07/24.
 */

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/24
 * \* Time: 12:03
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
//用户实体类
public class User {
    private String name;
    private String eamil;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEamil() {
        return eamil;
    }

    public void setEamil(String eamil) {
        this.eamil = eamil;
    }
}
