package com.bdqn.service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 123 on 2017/06/16.
 */
public interface IShowServiceDAO {
    public String show(String name, String type, int pageindex, int pagesize)throws SQLException,ClassNotFoundException;
}
