package com.njust.dao;

import com.njust.entity.CourseRemark;

import java.sql.*;

public class addCourseDao {
    public static int addCourse(int id,int course_id){ //学生添加课程
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/class_design?serverTimezone=UTC&characterEncoding=utf-8";
        String admin = "root";
        String pwd1 = "123456";
        Connection conn = null;
        PreparedStatement ps;
        try{
            String condition = "INSERT INTO studentcourse VALUES (?,?,?,?)";
            Class.forName(driver);
            conn = DriverManager.getConnection(url, admin, pwd1);
            ps = conn.prepareStatement(condition);
            ps.setInt(1,id);
            ps.setInt(2,course_id);
            ps.setInt(3,0);
            ps.setDouble(4,0.0);
            int m=ps.executeUpdate();
            if(m>0){
                return 1;//加入成功
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return -1; //系统异常
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}
