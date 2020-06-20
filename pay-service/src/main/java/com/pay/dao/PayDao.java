package com.pay.dao;

import com.pay.bean.PayAgent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PayDao extends BaseDao {

    //添加新用户
    public void addClient( String cid , String pwd ){

        Connection conn = null ;
        PreparedStatement pstmt = null ;
        String sql = "insert into PayAgent values(?,?,1000)" ;
        try {
            conn = getConnection() ;
            pstmt = conn.prepareStatement(sql) ;
            pstmt.setString(1,cid);
            pstmt.setString(2,pwd);
            pstmt.executeUpdate() ;
            closeAll(conn,pstmt,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //查询用户
    public PayAgent findByCid( String cid ){

        Connection conn = null ;
        PreparedStatement pstmt = null ;
        ResultSet rs = null ;
        String sql = "select * from PayAgent where cid=?" ;
        PayAgent pay = new PayAgent() ;
        try {
            conn = getConnection() ;
            pstmt = conn.prepareStatement(sql) ;
            pstmt.setString(1,cid);
            rs = pstmt.executeQuery() ;
            if( rs.next() ){
                pay = payInfo(rs) ;
            }
            closeAll(conn,pstmt,rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pay ;
    }

    //修改账户
    public void modifyBalance( String cid , double balance ){

        Connection conn = null ;
        PreparedStatement pstmt = null ;
        String sql = "update PayAgent set balance=? where cid = ? " ;
        try {
            conn = getConnection() ;
            pstmt = conn.prepareStatement(sql) ;
            pstmt.setDouble(1,balance);
            pstmt.setString(2,cid);
            pstmt.executeUpdate() ;
            closeAll(conn , pstmt, null );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //查询信息
    public PayAgent payInfo(ResultSet resultSet) throws Exception{

        PayAgent pay = new PayAgent();
        pay.setCid(resultSet.getString("cid"));
        pay.setPwd(resultSet.getString("pwd"));
        pay.setBalance(resultSet.getDouble("balance"));
        return pay ;
    }
}
