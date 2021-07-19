package com.njust.dao;

import com.njust.entity.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class getCourseDao {
    public static List<Course> getCourse(String category,int page) { //按照分类获取课程
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/class_design?serverTimezone=UTC&characterEncoding=utf-8";
        String admin = "root";
        String pwd1 = "123456";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Course> courses = new ArrayList<>();
        try {
            String condition = "select teacher,course_name,total_evaluate_numb,grade,creat_time,course_id,teacher_id from course where  category=?";
            Class.forName(driver);
            conn = DriverManager.getConnection(url, admin, pwd1);
            ps = conn.prepareStatement(condition);
            ps.setString(1, category);
            rs = ps.executeQuery();
            int i=1;
            while (rs.next()){
                if((int)Math.ceil(i/8)==page-1 || (i/8 == page && i%8==0)) {
                    String teacher = rs.getString(1);
                    String course_name = rs.getString(2);
                    int total_evaluate_numb = rs.getInt(3);
                    double grade = rs.getDouble(4);
                    Timestamp creat_time = rs.getTimestamp(5);
                    int course_id = rs.getInt(6);
                    int id = rs.getInt(7);
                    Course temp = new Course(category, creat_time, teacher, course_name, id, course_id, total_evaluate_numb, grade);
                    courses.add(temp);
                }
                i++;
                }
            } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return courses;
    }
    public static List<Course> getAllCourse(int currentPage){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/class_design?serverTimezone=UTC&characterEncoding=utf-8";
        String admin = "root";
        String pwd1 = "123456";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Course> courses = new ArrayList<>();
        try {
            String condition = "select teacher,course_name,total_evaluate_numb,grade,category,creat_time,course_id,teacher_id from course";
            Class.forName(driver);
            conn = DriverManager.getConnection(url, admin, pwd1);
            ps = conn.prepareStatement(condition);
            rs = ps.executeQuery();
            int i = 1;
            while (rs.next()) {
                if((int)Math.ceil(i/8)==currentPage-1 || (i/8 == currentPage && i%8==0)){
                    String teacher = rs.getString(1);
                    String course_name = rs.getString(2);
                    int total_evaluate_numb = rs.getInt(3);
                    double grade = rs.getDouble(4);
                    String category = rs.getString(5);
                    Timestamp creat_time = rs.getTimestamp(6);
                    int course_id = rs.getInt(7);
                    int id = rs.getInt(8);
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
    public static int countNum(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/class_design?serverTimezone=UTC&characterEncoding=utf-8";
        String admin = "root";
        String pwd1 = "123456";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int num = 0;
        try {
            String condition = "select count(*) from course";
            Class.forName(driver);
            conn = DriverManager.getConnection(url, admin, pwd1);
            ps = conn.prepareStatement(condition);
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
    public static int countNum(String category){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/class_design?serverTimezone=UTC&characterEncoding=utf-8";
        String admin = "root";
        String pwd1 = "123456";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int num = 0;
        try {
            String condition = "select count(*) from course where category=?";
            Class.forName(driver);
            conn = DriverManager.getConnection(url, admin, pwd1);
            ps = conn.prepareStatement(condition);
            ps.setString(1,category);
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
