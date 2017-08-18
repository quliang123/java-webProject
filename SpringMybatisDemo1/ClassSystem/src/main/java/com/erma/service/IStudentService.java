package com.erma.service;

import com.erma.model.Student;

import java.util.List;

/**
 * Created by 123 on 2017/08/11.
 */
public interface IStudentService {

    List<Student> getStusById(String name);
}
