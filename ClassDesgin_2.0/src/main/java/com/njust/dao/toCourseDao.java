package com.njust.dao;

import com.njust.entity.CourseRemark;

import java.sql.*;

public class toCourseDao {
    public static CourseRemark toCourse(int course_id, int id) {  //向学生展示课程信息 获取单个课程
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/class_design?serverTimezone=UTC&characterEncoding=utf-8";
        String admin = "root";
        String pwd1 = "123456";
        Connection conn = null;
        PreparedStatement ps;
        ResultSet rs = null;
        CourseRemark signalCourse = null;
        int bool_remark = -1;
        try {
            String condition = "select bool_remark,grade from studentcourse where course_id=? and student_id=?";
            Class.forName(driver);
            conn = DriverManager.getConnection(url, admin, pwd1);
            ps = conn.prepareStatement(condition);
            ps.setInt(1, course_id);
            ps.setInt(2, id);
            rs = ps.executeQuery();
            double signal_grade = 0;
            if (rs.next()) {
                signal_grade = rs.getDouble(2);
                bool_remark = rs.getInt(1);
            }else{
                bool_remark =-1; //-1表示学生未加入课程
            }
                String condition1 = "select teacher,course_name,course_introduce,total_evaluate_numb,grade from course where  course_id=?";
                ps=conn.prepareStatement(condition1);
                ps.setInt(1,course_id);
                rs = ps.executeQuery();
                if(rs.next()) {
                    String teacher = rs.getString(1);
                    String course_name = rs.getString(2);
                    String introduce = rs.getString(3);
                    int total = rs.getInt(4);
                    double grade = rs.getDouble(5);
                    signalCourse = new CourseRemark(bool_remark,teacher, course_name, introduce, course_id,total, grade,signal_grade);
                }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return signalCourse;
    }



}
