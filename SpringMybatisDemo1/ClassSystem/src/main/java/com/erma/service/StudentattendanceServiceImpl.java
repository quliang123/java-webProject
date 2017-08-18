package com.erma.service;

import com.erma.dao.StudentattendanceMapper;
import com.erma.model.Studentattendance;

import java.util.Date;
import java.util.List;

/**
 * Created by 123 on 2017/08/12.
 */

public class StudentattendanceServiceImpl implements IStudentattendanceService {


    private StudentattendanceMapper studentattendanceMapper;

    public StudentattendanceMapper getStudentattendanceMapper() {
        return studentattendanceMapper;
    }

    public void setStudentattendanceMapper(StudentattendanceMapper studentattendanceMapper) {
        this.studentattendanceMapper = studentattendanceMapper;
    }

    @Override
    public List<Studentattendance> getAllStusByDate(Date time) {
        return studentattendanceMapper.getAllStusByDate(time);
    }

    @Override
    public int save(Studentattendance studentattendance) {
        return studentattendanceMapper.save(studentattendance);
    }
}
