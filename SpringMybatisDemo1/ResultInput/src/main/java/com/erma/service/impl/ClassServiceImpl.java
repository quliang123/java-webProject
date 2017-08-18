package com.erma.service.impl;

import com.erma.dao.ClassInfoMapper;
import com.erma.model.Class_info;

import java.util.List;

/**
 * Created by 123 on 2017/08/09.
 */

public class ClassServiceImpl implements ClassInfoMapper {
    @Override
    public int saveClass(String name) {
        return classInfoMapper.saveClass(name);
    }

    @Override
    public List<Class_info> getAllData() {
        return classInfoMapper.getAllData();
    }


    private ClassInfoMapper classInfoMapper;

    public ClassInfoMapper getClassInfoMapper() {
        return classInfoMapper;
    }

    public void setClassInfoMapper(ClassInfoMapper classInfoMapper) {
        this.classInfoMapper = classInfoMapper;
    }


}
