package com.njust.dao;

import com.njust.entity.CourseRemark;

import java.sql.*;

public class remarkDao {
    public static int remark(int course_id, int id, double grade) throws ClassNotFoundException, SQLException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/class_design?serverTimezone=UTC&characterEncoding=utf-8";
        String admin = "root";
        String pwd1 = "123456";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;
            try {
                String search = "select grade,total_evaluate_numb from course where course_id=?";
                String condition = "update course set grade=? ,total_evaluate_numb=? where course_id=?"; //更新课程
                String updateStudent = "update studentcourse set bool_remark=?,grade=? where student_id=? and course_id=?";  //更新学生情况
                Class.forName(driver);
                conn = DriverManager.getConnection(url, admin, pwd1);
                ps = conn.prepareStatement(search);
                ps.setInt(1, course_id);
                res = ps.executeQuery();
                double grade_temp = 0;
                int total = 0; //总评价人数
                if (res.next()) {
                    grade_temp = res.getDouble(1);
                    total = res.getInt(2);
                }
                total++;
                grade_temp = ((grade_temp * (total - 1)) + grade) / total;
                ps = conn.prepareStatement(condition);
                ps.setDouble(1, grade_temp);
                ps.setDouble(2, total);
                ps.setInt(3, course_id);
                if (ps.executeUpdate() > 0) {
                    System.out.println(grade);
                    ps = conn.prepareStatement(updateStudent);
                    ps.setInt(1, 1);
                    ps.setDouble(2, grade);
                    ps.setInt(3, id);
                    ps.setInt(4, course_id);
                    if (ps.executeUpdate() > 0) {
                        return 1; //更新成功
                    }
                }
                return 0; //更新失败
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return -1; //系统异常
            } catch (SQLException e) {
                e.printStackTrace();
                return -1;
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            } finally {
                try{
                    if (conn != null) conn.close();
                    if (ps != null) ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return -1;
                } catch (Exception e) {
                    e.printStackTrace();
                    return -1;
                }
            }
    }
}
