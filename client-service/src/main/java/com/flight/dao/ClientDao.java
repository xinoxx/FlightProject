package com.flight.dao;

import com.flight.bean.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDao extends BaseDao {

    //获得账户信息
    public Client findClientByCid(String cid ){
        Client client = new Client() ;
        Connection connection = null ;
        String sql = "select * from Client where cid = ? " ;
        PreparedStatement pstmt = null ;
        ResultSet rs = null ;
        try {
            connection = getConnection() ;
            pstmt = connection.prepareStatement(sql) ;
            pstmt.setString(1 , cid );
            rs = pstmt.executeQuery() ;
            if( rs.next() ){
                client = findClient(rs) ;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("findClientByCid，获取账户连接出错！");
        }
        try {
            closeAll(connection,pstmt,rs);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("关闭异常");
        }
        return client ;
    }

    //添加账户信息
    public void addClient( String cid , String pwd ){

        Connection conn = null ;
        PreparedStatement pstmt = null ;
        String sql = "insert into Client values(?,?)" ;
        try {
            conn = getConnection() ;
            pstmt = conn.prepareStatement(sql) ;
            pstmt.setString(1,cid);
            pstmt.setString(2,pwd);
            pstmt.executeUpdate() ;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("addClient，获取账户连接出错！");
        }
        try {
            closeAll(conn,pstmt,null);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("关闭异常");
        }
    }

    private Client findClient(ResultSet rs){
        Client client = new Client( );
        try {
            client.setCid(rs.getString("cid"));
            client.setPwd(rs.getString("pwd"));
            if( rs.getString("cid").equals(null))
                return null ;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("findClient获取用户信息出错！");
        }
        return client ;
    }

}
