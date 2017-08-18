package com.erma.service;

import com.erma.dao.ClassesMapper;
import com.erma.model.Classes;

import java.util.List;

/**
 * Created by 123 on 2017/08/11.
 */

public class ClassesServiceImpl implements IClassesService {
    @Override
    public List<Classes> AllClass() {
        return classesMapper.AllClass();
    }


    public ClassesMapper getClassesMapper() {
        return classesMapper;
    }

    public void setClassesMapper(ClassesMapper classesMapper) {
        this.classesMapper = classesMapper;
    }

    private ClassesMapper classesMapper;


}
