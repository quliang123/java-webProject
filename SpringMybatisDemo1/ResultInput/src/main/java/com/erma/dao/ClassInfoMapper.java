package com.erma.dao;

import com.erma.model.Class_info;

import java.util.List;

/**
 * Created by 123 on 2017/08/09.
 */
public interface ClassInfoMapper {
    public int saveClass(String name);

    public List<Class_info> getAllData();
}
