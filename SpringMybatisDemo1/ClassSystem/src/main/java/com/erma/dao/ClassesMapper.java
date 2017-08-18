package com.erma.dao;

import com.erma.model.Classes;

import java.util.List;

public interface ClassesMapper {

    List<Classes> AllClass();

    int deleteByPrimaryKey(Integer classesid);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer classesid);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
}