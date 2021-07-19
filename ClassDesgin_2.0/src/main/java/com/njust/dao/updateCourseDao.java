package com.njust.dao;

import java.sql.*;

public class updateCourseDao {
    public static int updateCourse(int course_id, String course_introduce) {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/class_design?serverTimezone=UTC&characterEncoding=utf-8";
        String admin = "root";
        String pwd1 = "123456";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        System.out.println(course_id);
        try {
            String condition = "update course set course_introduce=? where course_id=?";
            Class.forName(driver);
            conn = DriverManager.getConnection(url, admin, pwd1);
            ps = conn.prepareStatement(condition);
            ps.setString(1, course_introduce);
            ps.setInt(2, course_id);
            if (ps.executeUpdate() > 0) {
                return 1; //更新成功
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }
}
