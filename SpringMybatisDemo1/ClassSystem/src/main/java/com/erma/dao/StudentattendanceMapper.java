package com.erma.dao;

import com.erma.model.Studentattendance;

import java.util.Date;
import java.util.List;

public interface StudentattendanceMapper {
    List<Studentattendance> getAllStusByDate(Date time);

    int save(Studentattendance studentattendance);

    int deleteByPrimaryKey(Integer studentattendaneid);

    int insert(Studentattendance record);

    int insertSelective(Studentattendance record);

    Studentattendance selectByPrimaryKey(Integer studentattendaneid);

    int updateByPrimaryKeySelective(Studentattendance record);

    int updateByPrimaryKey(Studentattendance record);
}