package com.njust.dao;

import com.njust.entity.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class searchDao {
    public static Course search(int bool_search, String key) throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/class_design?serverTimezone=UTC&characterEncoding=utf-8";
        String admin = "root";
        String pwd1 = "123456";
        Connection conn = null;
        PreparedStatement ps;
        ResultSet rs = null;
        List<Course> courses = new ArrayList<>();
        try {
            if (bool_search == 0) { //表示从下拉标签搜索
                String condition = "select teacher,course_name,grade,course_introduce,course_id from course where category =?";
                Class.forName(driver);
                conn = DriverManager.getConnection(url, admin, pwd1);
                ps = conn.prepareStatement(condition);
                ps.setString(1,key);
                rs = ps.executeQuery();
                while(rs.next()){
                    String teacher = rs.getString(1);
                    String course_name = rs.getString(2);
                    double grade = rs.getDouble(3);
                    String course_introduce = rs.getString(4);
                    int course_id =rs.getInt(5);
                    Course temp = new Course(key, teacher, course_name, course_name, course_id,grade);
                    courses.add(temp);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
