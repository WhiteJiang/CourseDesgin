package com.njust.dao;

import java.sql.*;

public class uploadCourseDao { //老师上传课程
    public static int uploadCourse(int course_id,int chapter_id,String courseAddress,String chapter_name){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/class_design?serverTimezone=UTC&characterEncoding=utf-8";
        String admin = "root";
        String pwd1 = "123456";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
                String insert="INSERT INTO coursechapter VALUES (?,?,?,?)";
                Class.forName(driver);
                conn = DriverManager.getConnection(url, admin, pwd1);
                ps=conn.prepareStatement(insert);
                ps.setInt(1,course_id);
                ps.setInt(2,chapter_id);
                ps.setString(3,courseAddress);
                ps.setString(4,chapter_name);
                if(ps.executeUpdate()>0){
                    return 1;//上传成功
                }
                return 0;//上传失败
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
