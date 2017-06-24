package com.bdqn.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.junit.Test;

/**
 * Created by 123 on 2017/06/17.
 */
public class DButil {

    private final static String diver="com.mysql.jdbc.Driver";
    public static final String url="jdbc:mysql://localhost:3306/happy_orangle_lala";
    public static final String username="sa";
    public static final String password="123";

    public Connection con;

    static{
        try {
            //字符串对应的类装载到内存
            Class.forName(diver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //1.获取连接接口
    public Connection getConection() throws SQLException{
        if (con==null||con.isClosed()) {
            con=DriverManager.getConnection(url, username, password);
        }
        return con;
    }

    //使用可插拔的策略执行SQL查询并处理结果集
    QueryRunner qr=new QueryRunner();

    // 将ResultSet转换为List<Object[]>的ResultSetHandler实现�?
    ArrayListHandler al=new ArrayListHandler();//List<Object[]>



    //查询操作
    public List<Object[]> selectList(String sql,Object...objs) throws SQLException{
        List<Object[]> list= qr.query(getConection(),sql,al,objs);
        return list;
    }

    //更新操作
    public boolean update(String sql,Object...objs) throws SQLException{
        boolean flag=false;
        int num= qr.update(getConection(),sql,objs);
        if(num>0){
            flag=true;
        }
        return flag;
    }
}
