package cn.ql.spring05dixml;/**
 * Created by 123 on 2017/07/26.
 */

import cn.ql.spring05dixml.Car;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 123
 * \* Date: 2017/07/26
 * \* Time: 10:16
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Student {
    private int stuId;
    private String stuName;
    private Car car;

    public Student() {
    }

    public Student(int stuId, String stuName, Car car) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.car = car;
    }

    public int getStuId() {

        return stuId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", car=" + car +
                '}';
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
