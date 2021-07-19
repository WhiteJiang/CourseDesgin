package com.njust.dao;

import com.njust.entity.Course;

import java.sql.*;

public class creatCourseDao { //老师创建课程
    public static int creatCourse(Course course) throws SQLException, ClassNotFoundException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/class_design?serverTimezone=UTC&characterEncoding=utf-8";
        String admin = "root";
        String pwd1 = "123456";
        Connection conn = null;
        PreparedStatement ps;
        ResultSet rs = null;
        String category = course.getCategory();
        Timestamp creatTime = course.getCreatTime();
        String teacher = course.getTeacher();
        String course_name = course.getCourse_name();
        String course_introduce = course.getCourse_introduce();
        double grade = course.getGrade();
        int total_evaluate_numb = course.getTotal_evaluate_numb();
        int teacher_id = course.getId();
        try {
            String condition = "select teacher,course_name teacher_id,category from course where teacher =? and course_name =? and teacher_id=? and category=?";
            Class.forName(driver);
            conn = DriverManager.getConnection(url, admin, pwd1);
            ps=conn.prepareStatement(condition);
            ps.setString(1,teacher);
            ps.setString(2,course_name);
            ps.setInt(3,teacher_id);
            ps.setString(4,category);
            rs = ps.executeQuery();
            if (rs.next()){
                return 0; //已存在课程
            }
            else{
                PreparedStatement insertSql;
                condition = "select max(course_id) from course";
                ps=conn.prepareStatement(condition);
                rs=ps.executeQuery();
                int course_id = 0;
                if(rs.next()) {
                    course_id = rs.getInt(1);
                }
                course_id++;
                String insert="INSERT INTO course VALUES (?,?,?,?,?,?,?,?,?)";
                Class.forName(driver);
                conn = DriverManager.getConnection(url, admin, pwd1);
                insertSql = conn.prepareStatement(insert);
                insertSql.setString(1,category);
                insertSql.setTimestamp(2,creatTime);
                insertSql.setString(3,teacher);
                insertSql.setInt(4,total_evaluate_numb);
                insertSql.setDouble(5,grade);
                insertSql.setString(6,course_name);
                insertSql.setInt(7,teacher_id);
                insertSql.setInt(8,course_id);
                insertSql.setString(9,course_introduce);
                int m=insertSql.executeUpdate();
                if(m != 0){
                    //创建成功
                    return 1;
                }
                return 0;
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
            return -1; //创建失败 系统异常
        }
        catch (SQLException e){
            e.printStackTrace();
            return -1;
        }
        catch (Exception e){
            e.printStackTrace();
            return -1;
        }
        finally {
            try {
                if (rs != null) rs.close();
                if (conn != null) conn.close();
            }catch (SQLException e) {
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
