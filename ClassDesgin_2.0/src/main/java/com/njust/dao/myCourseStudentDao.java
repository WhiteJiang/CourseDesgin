package com.njust.dao;

import com.njust.entity.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class myCourseStudentDao { //学生展示其加入的课程
    public static List<Course> myCourseStudent(int id){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/class_design?serverTimezone=UTC&characterEncoding=utf-8";
        String admin = "root";
        String pwd1 = "123456";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Course> courses = new ArrayList<>();
        try {
            String conditionCourseId = "select course_id from studentcourse where student_id = ?";
            String condition = "select teacher,course_name,total_evaluate_numb,grade,category,creat_time from course where course_id=?";
            Class.forName(driver);
            conn = DriverManager.getConnection(url, admin, pwd1);
            ps = conn.prepareStatement(conditionCourseId);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            int []courseId = new int[1000];
            int i=0;
            while(rs.next()){
                courseId[i] = rs.getInt(1);
                i++;
            }
            for(int j=0;j<courseId.length;j++){
                ps = conn.prepareStatement(condition);
                ps.setInt(1,courseId[j]);
                rs= ps.executeQuery();
                while (rs.next()) {
                    String teacher = rs.getString(1);
                    String course_name = rs.getString(2);
                    int total_evaluate_numb = rs.getInt(3);
                    double grade = rs.getDouble(4);
                    String category = rs.getString(5);
                    Timestamp creat_time = rs.getTimestamp(6);
                    Course temp = new Course(category, creat_time, teacher, course_name, id,courseId[j],total_evaluate_numb, grade);
                    courses.add(temp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return courses;
    }
}
