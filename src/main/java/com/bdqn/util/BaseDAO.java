package com.bdqn.util;

import java.sql.*;

/**
 * Created by 123 on 2017/06/16.
 */
public class BaseDAO {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/happy_orangle_lala";
    private static final String username = "sa";
    private static final String pwd = "123";
    private Connection con=null;
    private  PreparedStatement ps=null;
    private ResultSet rs=null;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        if(con==null||con.isClosed()){
            con= DriverManager.getConnection(url,username,pwd);
        }
        return con;
    }

    public ResultSet executeQuery(String sql,Object...obj) throws ClassNotFoundException, SQLException{
        con=getConnection();
        ps=con.prepareStatement(sql);
        for (int i = 0; i < obj.length; i++) {
            ps.setObject(i+1, obj[i]);
        }
        return ps.executeQuery();

    }

    public int executeUpdate(String sql,Object...obj) throws ClassNotFoundException, SQLException{
        con=getConnection();
        ps=con.prepareStatement(sql);
        for (int i = 0; i < obj.length; i++) {
            ps.setObject(i+1, obj[i]);
        }
        return ps.executeUpdate();
    }

    public void closeAll() throws SQLException{
        if(rs!=null){
            rs.close();
        }
        if(ps!=null){
            ps.close();
        }
        if(con!=null){
            con.close();
        }
    }


}
