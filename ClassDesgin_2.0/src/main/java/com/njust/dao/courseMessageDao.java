package com.njust.dao;

import com.njust.entity.Course;

import java.sql.*;

public class courseMessageDao {
    public static Course courseMessage(int course_id) {  //获取课程信息
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/class_design?serverTimezone=UTC&characterEncoding=utf-8";
        String admin = "root";
        String pwd1 = "123456";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Course course = null;
        try{
            String condition = "select teacher,course_name,total_evaluate_numb,grade,category,creat_time,course_introduce,teacher_id from course where course_id=?";
            Class.forName(driver);
            conn = DriverManager.getConnection(url, admin, pwd1);
            ps = conn.prepareStatement(condition);
            ps.setInt(1, course_id);
            rs = ps.executeQuery();
            if(rs.next()){
                String teacher = rs.getString(1);
                String course_name = rs.getString(2);
                int total_evaluate_numb = rs.getInt(3);
                double grade = rs.getDouble(4);
                String category = rs.getString(5);
                Timestamp creat_time = rs.getTimestamp(6);
                String course_introduce = rs.getString(7);
                int teacher_id = rs.getInt(8);
                course =new Course(category, creat_time, teacher, course_name, course_introduce,teacher_id,course_id,total_evaluate_numb, grade);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return course;
    }
}
