package com.bdqn.service.impl;

import com.bdqn.dao.IShowDAO;
import com.bdqn.dao.impl.ShowDAOimpl;
import com.bdqn.service.IShowServiceDAO;
import com.bdqn.util.RedisClient;
import com.google.gson.Gson;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by 123 on 2017/06/16.
 */

public class ShowServiceDAOImpl implements IShowServiceDAO {
    ShowDAOimpl impl = new ShowDAOimpl();
    RedisClient redisClient = new RedisClient();

    public String show(String name, String type, int pageindex, int pagesize) throws SQLException, ClassNotFoundException {

        String data = null;

        if (redisClient.jedis.get( "ConditionalPaging" ) == null) {
            System.out.println("if");
           return   redisClient.jedis.set("ConditionalPaging",impl.show( name, type, pageindex, pagesize ));
        }
        System.out.println("取到了数据");
        return redisClient.jedis.get( "ConditionalPaging" );
    }
}
