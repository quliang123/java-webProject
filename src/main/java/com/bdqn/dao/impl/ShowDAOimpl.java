package com.bdqn.dao.impl;

import com.bdqn.dao.IShowDAO;
import com.bdqn.util.DButil;
import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import javax.xml.transform.Source;
import java.sql.SQLException;
import java.util.List;

//<editor-fold desc="Description">

/**
 * //</editor-fold>
 * Created by 123 on 2017/06/16.
 */
public class ShowDAOimpl extends DButil implements IShowDAO {
    Gson gson = new Gson();
    @Test
    public void TestShow() throws SQLException, ClassNotFoundException {
        String list = show( "", "", 0, 2 );

        System.out.println(list);
    }


    public String show(String name, String type, int pageindex, int pagesize) throws SQLException, ClassNotFoundException {
        //List<shopclasstypelist> list=new ArrayList<shopclasstypelist>();
        StringBuffer sb = new StringBuffer( "select * from `shopclasstypelist`  limit ?,?" );
        List<Object[]> list = selectList( sb.toString(), pageindex, pagesize );
        return  gson.toJson( list );
    }

}
