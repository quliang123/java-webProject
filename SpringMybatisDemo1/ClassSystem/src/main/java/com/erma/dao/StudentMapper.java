package com.erma.dao;

import com.erma.model.Student;

import java.util.List;

public interface StudentMapper {

    List<Student> getStusById(String name);

    int deleteByPrimaryKey(Integer studentid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer studentid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}