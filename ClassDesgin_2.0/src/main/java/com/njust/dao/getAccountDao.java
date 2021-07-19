package com.njust.dao;

import java.sql.*;

public class getAccountDao {
    public static String getAccount(String account){ //修改密码时用于获取账户
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/class_design?serverTimezone=UTC&characterEncoding=utf-8";
        String admin = "root";
        String pwd1 = "123456";
        Connection conn = null;
        PreparedStatement ps;
        ResultSet rs=null;
        try{
            String condition = "select email from useraccount where account=?";
            Class.forName(driver);
            conn = DriverManager.getConnection(url, admin, pwd1);
            ps = conn.prepareStatement(condition);
            ps.setString(1,account);
            rs=ps.executeQuery();
            if(rs.next()){
                String email = rs.getString(1);
                return email;//表示有账号
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "error";
        } catch (SQLException e) {
            e.printStackTrace();
            return "error";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return null;
    }
}
