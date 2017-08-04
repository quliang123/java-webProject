package cn.ql.spring05dixml;/**
 * Created by 123 on 2017/07/26.
 */

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/26
 * \* Time: 10:18
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Car {
    private String color;
    private String name;

    public Car() {
    }

    public Car(String color, String name) {
        this.color = color;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getColor() {

        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
