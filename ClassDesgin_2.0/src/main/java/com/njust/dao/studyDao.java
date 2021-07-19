package com.njust.dao;

import com.njust.entity.CourseBigChapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class studyDao {
    public static List<CourseBigChapter> study(int course_id){
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
            ps = conn.prepareStatement(condition);
            ps.setInt(1,course_id);
            rs=ps.executeQuery();
            while(rs.next()){
                int chapter_id =rs.getInt(1);
                String name = rs.getString(2);
                String address = rs.getString(3);
                CourseBigChapter courseBigChapter = new CourseBigChapter(chapter_id,address,name);
                courseBigChapters.add(courseBigChapter);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return courseBigChapters;
    }
}
