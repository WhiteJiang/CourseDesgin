package com.njust.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class exitCourseDao {
    public static int exitCourse(int course_id,int id){ //学生退出课程
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/class_design?serverTimezone=UTC&characterEncoding=utf-8";
        String admin = "root";
        String pwd1 = "123456";
        Connection conn = null;
        PreparedStatement ps;
        try{
            String condition ="delete from studentcourse where course_id=? and student_id=?";
            Class.forName(driver);
            conn = DriverManager.getConnection(url, admin, pwd1);
            ps = conn.prepareStatement(condition);
            ps.setInt(1,course_id);
            ps.setInt(2,id);
            int m = ps.executeUpdate();
            if(m>0){
                return 1;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        return 0;
    }
}
