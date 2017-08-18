package com.erma.service;

import com.erma.model.Class_info;

import java.util.List;

/**
 * Created by 123 on 2017/08/09.
 */
public interface IClassInfoService {
    public int saveClass(String name);

    public List<Class_info> getAllData();
}
