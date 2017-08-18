package com.erma.model;

import java.util.Date;
import java.util.List;

public class Studentattendance {
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    private Integer studentattendaneid;

    private Integer studentid;

    private Date attendancetime;

    private Integer attendanceid;

    private Student student;
    private Attendance attendance;

    public Student getStudent() {

        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    public Integer getStudentattendaneid() {
        return studentattendaneid;
    }

    public void setStudentattendaneid(Integer studentattendaneid) {
        this.studentattendaneid = studentattendaneid;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Date getAttendancetime() {
        return attendancetime;
    }

    public void setAttendancetime(Date attendancetime) {
        this.attendancetime = attendancetime;
    }

    public Integer getAttendanceid() {
        return attendanceid;
    }

    public void setAttendanceid(Integer attendanceid) {
        this.attendanceid = attendanceid;
    }
}