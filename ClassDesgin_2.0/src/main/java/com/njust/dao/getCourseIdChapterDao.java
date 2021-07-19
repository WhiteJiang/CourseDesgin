package com.njust.dao;

import com.njust.entity.CourseBigChapter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class getCourseIdChapterDao {
    public static List<CourseBigChapter> getCourseIDChapter(int course_id){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/class_design?serverTimezone=UTC&characterEncoding=utf-8";
        String admin = "root";
        String pwd1 = "123456";
        Connection conn = null;
        PreparedStatement ps;
        ResultSet rs = null;
        List<CourseBigChapter> courseBigChapters = new ArrayList<>();
        try{
            String condition = "select course_chapter_id,chapter_name,course_address from coursechapter where course_id =?";
            Class.forName(driver);
            conn = DriverManager.getConnection(url, admin, pwd1);
            ps=conn.prepareStatement(condition);
            ps.setInt(1,course_id);
            rs =ps.executeQuery();
            while
            (rs.next()){
                int chapter_id = rs.getInt(1);
                String name = rs.getString(2);
                String address = rs.getString(3);
                CourseBigChapter temp = new CourseBigChapter(course_id, chapter_id,address, name);
                courseBigChapters.add(temp); //获取该课程所有的课件信息
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return courseBigChapters;
    }
}
