package com.erma.model;

import java.util.List;

public class Classes {

    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    private List<Student> stus;

    @Override
    public String toString() {
        return "Classes{" +
                "stus=" + stus +
                ", classesid=" + classesid +
                ", classesanem='" + classesanem + '\'' +
                '}';
    }

    public List<Student> getStus() {
        return stus;
    }

    public void setStus(List<Student> stus) {
        this.stus = stus;
    }

    private Integer classesid;

    private String classesanem;



    public Integer getClassesid() {
        return classesid;
    }

    public void setClassesid(Integer classesid) {
        this.classesid = classesid;
    }

    public String getClassesanem() {
        return classesanem;
    }

    public void setClassesanem(String classesanem) {
        this.classesanem = classesanem == null ? null : classesanem.trim();
    }
}