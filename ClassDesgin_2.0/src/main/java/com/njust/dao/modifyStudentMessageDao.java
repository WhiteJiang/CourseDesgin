package com.njust.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class modifyStudentMessageDao { //修改学生信息
    public static int modifyStudentMessage(int id,int bool_teacher,String phone,String email,String name){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/class_design?serverTimezone=UTC&characterEncoding=utf-8";
        String admin = "root";
        String pwd1 = "123456";
        Connection conn = null;
        PreparedStatement ps = null;
        int flag =0; //用来判断是否更新成功
        try{
            String condition = "update useraccount set phone=? ,email=? ,userName =? where id=?";
            Class.forName(driver);
            conn = DriverManager.getConnection(url, admin, pwd1);
            ps=conn.prepareStatement(condition);
            ps.setString(1,phone);
            ps.setString(2,email);
            ps.setString(3,name);
            ps.setInt(4,id);
            flag +=ps.executeUpdate();
            if(bool_teacher == 1){
                condition = "update course set teacher =? where teacher_id=?";
                ps=conn.prepareStatement(condition);
                ps.setString(1,name);
                ps.setInt(2,id);
                flag += ps.executeUpdate();
                if(flag >=2 || (flag ==1 &&ps.executeUpdate() ==0)){
                    return 1;
                }
            }
            if(bool_teacher ==0 &&flag ==1){
                return 1;
            }
            return 0; //更新失败
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return -1;
        }finally {
            try{
                if(conn!=null) conn.close();
                if(ps!=null) ps.close();;
            } catch (SQLException e) {
                e.printStackTrace();
                return -1;
            }catch (Exception e){
                e.printStackTrace();
                return -1;
            }
        }
    }
}
