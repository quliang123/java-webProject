package com.erma.service;

import com.erma.model.Studentattendance;

import java.util.Date;
import java.util.List;

/**
 * Created by 123 on 2017/08/12.
 */
public interface IStudentattendanceService {
    List<Studentattendance> getAllStusByDate(Date time);
    int save(Studentattendance studentattendance);
}
