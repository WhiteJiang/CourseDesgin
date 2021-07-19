package com.njust.dao;

import com.njust.entity.User;

import java.sql.*;

public class registerDao { //实现学生注册
    public static int register(User user) throws SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/class_design?serverTimezone=UTC&characterEncoding=utf-8";
        String admin = "root";
        String pwd1 = "123456";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PreparedStatement insertSql;
        try{
            String insert="INSERT INTO useraccount VALUES (?,?,?,?,?,?,?)";
            String countNumb = "select count(*) as total from useraccount";
            String condition="select * from useraccount where account=?";
            Class.forName(driver);
            conn = DriverManager.getConnection(url, admin, pwd1);
            ps=conn.prepareStatement(condition);
            ps.setString(1,user.getAccount());
            rs = ps.executeQuery();
            int id=0;
            if (rs.next()){
                    return 0; //账户已存在
            }
            ps=conn.prepareStatement(countNumb);
            rs=ps.executeQuery();
            if(rs.next()) {
                id = rs.getInt("total");
            }
            id++;
            user.setId(id);
            insertSql = conn.prepareStatement(insert);
            insertSql.setInt(1,id);
            insertSql.setString(2,user.getAccount());
            insertSql.setString(3,user.getPwd());
            insertSql.setInt(4,user.getBool_teacher());
            insertSql.setString(5,null);
            insertSql.setString(6,user.getEmail());
            insertSql.setString(7,null);
            int m=insertSql.executeUpdate();
            if(m != 0){
                //注册成功
                return 1;
            }
            return 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return -1;//系统异常
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }finally {
            try {
                if (conn != null) conn.close();
                if (rs != null) rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
