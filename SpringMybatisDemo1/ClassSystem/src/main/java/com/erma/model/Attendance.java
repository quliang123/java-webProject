package com.erma.model;

public class Attendance {

    private Integer attendanceid;

    private String attendancename;

    public Integer getAttendanceid() {
        return attendanceid;
    }

    public void setAttendanceid(Integer attendanceid) {
        this.attendanceid = attendanceid;
    }

    public String getAttendancename() {
        return attendancename;
    }

    public void setAttendancename(String attendancename) {
        this.attendancename = attendancename == null ? null : attendancename.trim();
    }
}