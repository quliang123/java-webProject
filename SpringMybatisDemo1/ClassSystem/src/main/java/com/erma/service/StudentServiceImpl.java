package com.erma.service;

import com.erma.dao.StudentMapper;
import com.erma.model.Student;

import java.util.List;

/**
 * Created by 123 on 2017/08/11.
 */

public class StudentServiceImpl implements IStudentService {


private StudentMapper studentMapper;

    public StudentMapper getStudentMapper() {
        return studentMapper;
    }

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }



    @Override
    public List<Student> getStusById(String name) {
        return studentMapper.getStusById(name);
    }
}
