package com.njust.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class modifyPwdDao {
    public static int modifyPwd(String pwd,String account){ //修改密码
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/class_design?serverTimezone=UTC&characterEncoding=utf-8";
        String admin = "root";
        String pwd1 = "123456";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            String condition = "update useraccount set pwd=? where account=?";
            Class.forName(driver);
            conn = DriverManager.getConnection(url, admin, pwd1);
            ps=conn.prepareStatement(condition);
            ps.setString(1,pwd);
            ps.setString(2,account);
            if(ps.executeUpdate()>0){
                return 1; //修改成功
            }else{
                return 0;//更新失败
            }
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
