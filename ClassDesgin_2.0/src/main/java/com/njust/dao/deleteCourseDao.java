package com.njust.dao;

import java.io.File;
import java.sql.*;

public class deleteCourseDao {
    public static  int deleteCourse(int course_id){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/class_design?serverTimezone=UTC&characterEncoding=utf-8";
        String admin = "root";
        String pwd1 = "123456";
        Connection conn = null;
        PreparedStatement ps;
        ResultSet rs = null;
        try{
            String deleteCourse = "delete from course where course_id =?";
            Class.forName(driver);
            conn = DriverManager.getConnection(url, admin, pwd1);
            ps=conn.prepareStatement(deleteCourse);
            ps.setInt(1,course_id);
            if(ps.executeUpdate()>0){
                String getVideo ="select course_address from coursechapter where course_id =?";
                ps=conn.prepareStatement(getVideo);
                ps.setInt(1,course_id);
                rs = ps.executeQuery();
                while(rs.next()){
                    String address = rs.getString(1);
                    System.out.println(address);
                    deleteVideo(address);
                }
                String deleteVideo = "delete from coursechapter where course_id=?";
                ps = conn.prepareStatement(deleteVideo);
                ps.setInt(1,course_id);
                ps.executeUpdate();
                String deleteStudent = "delete from studentcourse where course_id=?";
                ps=conn.prepareStatement(deleteStudent);
                ps.setInt(1,course_id);
                ps.executeUpdate();
                return 1;
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
    public static void deleteVideo(String address){
        File file = new File("C:\\Users\\White Jiang\\IdeaProjects\\ClassDesgin_2.0\\target\\ClassDesgin\\"+address);
        if(file.delete()){
            System.out.println(address+"deleted");
        }else{
            System.out.println(address+" not deleted");
        }
    }
}
