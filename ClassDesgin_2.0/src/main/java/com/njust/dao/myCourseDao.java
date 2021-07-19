package com.njust.dao;

import com.njust.entity.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//展示老师所有的课程大概
public class myCourseDao {
    public static List<Course> myCourse(int id,int current_page) throws SQLException, ClassNotFoundException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/class_design?serverTimezone=UTC&characterEncoding=utf-8";
        String admin = "root";
        String pwd1 = "123456";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Course> courses = new ArrayList<>();
        try {
            String condition = "select teacher,course_name,total_evaluate_numb,grade,category,creat_time,course_id from course where  teacher_id=?";
            Class.forName(driver);
            conn = DriverManager.getConnection(url, admin, pwd1);
            ps = conn.prepareStatement(condition);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            int i = 1;
            while (rs.next()) {
                if((int)Math.ceil(i/8)==current_page-1 || (i/8 == current_page && i%8==0)){
                    String teacher = rs.getString(1);
                    String course_name = rs.getString(2);
                    int total_evaluate_numb = rs.getInt(3);
                    double grade = rs.getDouble(4);
                    String category = rs.getString(5);
                    Timestamp creat_time = rs.getTimestamp(6);
                    int course_id = rs.getInt(7);
                    Course temp = new Course(category, creat_time, teacher, course_name, id,course_id, total_evaluate_numb, grade);
                    courses.add(temp);
                }
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return courses;
    }
    public static int countNum(int id){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/class_design?serverTimezone=UTC&characterEncoding=utf-8";
        String admin = "root";
        String pwd1 = "123456";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int num = 0;
        try {
            String condition = "select count(*) from course where  teacher_id=?";
            Class.forName(driver);
            conn = DriverManager.getConnection(url, admin, pwd1);
            ps = conn.prepareStatement(condition);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                num = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return num;
    }
}
