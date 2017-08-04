package cn.ql.spring07annotationdi;/**
 * Created by 123 on 2017/07/26.
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/26
 * \* Time: 12:13
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Component("car")
public class Car {
    @Value("了铂金")
    private String name;
    @Value("绿色")
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
