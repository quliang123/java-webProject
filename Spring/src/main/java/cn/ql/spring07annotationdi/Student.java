package cn.ql.spring07annotationdi;/**
 * Created by 123 on 2017/07/26.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/26
 * \* Time: 11:35
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 * <p>
 * 7注解的底层不是用set方法实现的，二十
 */
@Component("stu")
public class Student {
    @Value("ql")
    private String name;

    @Autowired    //这是spring自带的
    @Qualifier("car")//@Resource(name = "car")   jdk
    private Car car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void say() {
        System.out.println(name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", car=" + car +
                '}';
    }
}
