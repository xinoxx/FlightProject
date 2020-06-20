package com.flight.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDao {

    public DataSource dataSource ;
    public BaseDao(){
        try {
            Context context = new InitialContext();
            dataSource = (DataSource)context.lookup("java:comp/env/jdbc/flightDB") ;
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws Exception{
        return dataSource.getConnection() ;
    }

    public void closeAll(Connection conn , Statement stmt , ResultSet rs ) throws SQLException {
        if( rs!=null ) rs.close();
        if( stmt!=null ) stmt.close();
        if( conn!=null ) conn.close();
    }
}
