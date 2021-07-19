package com.njust.dao;
import com.njust.entity.User;

import java.sql.*;

public class loginDao { //实现学生登录
    public static User login(User user) throws SQLException, ClassNotFoundException {
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/class_design?serverTimezone=UTC&characterEncoding=utf-8";
            String admin = "root";
            String pwd1 = "123456";
            Connection conn = null;
            PreparedStatement ps;
            ResultSet rs = null;
            String Account = user.getAccount();
            String Pwd = user.getPwd();
            try {
                String condition = "select id,bool_teacher,userName,phone,email from useraccount where account =? and pwd =?";
                Class.forName(driver);
                conn = DriverManager.getConnection(url, admin, pwd1);
                ps=conn.prepareStatement(condition);
                ps.setString(1,Account);
                ps.setString(2,Pwd);
                rs = ps.executeQuery();
                User user1;
                if (rs.next()){
                    user1 = new User(rs.getInt(1),Account,Pwd,rs.getInt(2),rs.getString(4),rs.getString(5),rs.getString(3));
                    return user1;
                }
                String conditionAccount = "select * from useraccount where account =?";
                ps = conn.prepareStatement(conditionAccount);
                ps.setString(1,Account);
                rs = ps.executeQuery();
                if(rs.next()){
                    user1 = new User(-1,-1,""); //-1表示密码错误
                }
                else{
                    user1 = new User(-2,-2,""); //-2表示账号不存在
                }
                return user1;
            }catch (ClassNotFoundException e){
                e.printStackTrace();
                return  null; //登陆失败 系统异常
            }
            catch (SQLException e){
              e.printStackTrace();
                return null;
            }
             catch (Exception e){
                e.printStackTrace();
                return null;
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
