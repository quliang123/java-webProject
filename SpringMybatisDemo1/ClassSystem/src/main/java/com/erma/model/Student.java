package com.erma.model;

import java.util.Date;

public class Student {
    private Classes classes;

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    private Integer studentid;

    private String studentname;

    private String classesid;

    private Date studentcatetime;

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname == null ? null : studentname.trim();
    }

    public String getClassesid() {
        return classesid;
    }

    public void setClassesid(String classesid) {
        this.classesid = classesid == null ? null : classesid.trim();
    }

    public Date getStudentcatetime() {
        return studentcatetime;
    }

    public void setStudentcatetime(Date studentcatetime) {
        this.studentcatetime = studentcatetime;
    }
}