package com.njust.controller;

import com.njust.dao.*;
import com.njust.dao.loginDao;
import com.njust.entity.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class loginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
            req.setCharacterEncoding("utf-8");
            String account = req.getParameter("account");
            String pwd = req.getParameter("pwd");
            User user = new User(account, pwd);
            HttpSession session = req.getSession();
            try {
                User user1 = loginDao.login(user);
                if(user1!=null) {
                    if (user1.getBool_teacher() == 1) {
                        session.setAttribute("email",user1.getEmail());
                        session.setAttribute("phone",user1.getPhone());
                        session.setAttribute("id", user1.getId());
                        session.setAttribute("bool_teacher", 1);
                        session.setAttribute("pwd", pwd);
                        session.setAttribute("account", account);
                        session.setAttribute("name", user1.getName());
                        session.setAttribute("current_page",1);
                        //session.setAttribute("isLogin",1);
                        resp.sendRedirect("myCourseServlet"); //如果是老师，跳转到老师的界面
                    } else if (user1.getBool_teacher() == 0) {
                        session.setAttribute("phone",user1.getPhone());
                        session.setAttribute("id", user1.getId());
                        session.setAttribute("bool_teacher", 0);
                        session.setAttribute("pwd", pwd);
                        session.setAttribute("account", account);
                        session.setAttribute("name", user1.getName());
                        session.setAttribute("email",user1.getEmail());
                        session.setAttribute("computer_current_page",1);
                        session.setAttribute("math_current_page",1); //用于课程展示用
                        session.setAttribute("student_current_page",1);
                        resp.sendRedirect("getCourseServlet"); //跳转到学生页面
                    } else if (user1.getId() == -1) {
                        //跳转登录页面，提示密码错误
                        req.getSession().setAttribute("flag", -1);
                        resp.sendRedirect("login_register/login_register.jsp");
                    } else if(user1.getId() ==-2) {
                        //提示账号不存在
                        req.getSession().setAttribute("flag", -2);
                        resp.sendRedirect("login_register/login_register.jsp");
                    }
                }
                else {
                    resp.sendRedirect("login_register/login_register.jsp"); //弹出错误信息 系统异常
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
