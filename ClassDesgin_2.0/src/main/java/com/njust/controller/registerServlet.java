package com.njust.controller;

import com.njust.dao.*;
import com.njust.entity.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class registerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String account = req.getParameter("account");
        String pwd = req.getParameter("pwd");
        String email = req.getParameter("email");
        int bool_teacher = Integer.parseInt(req.getParameter("ident"));
        System.out.println(bool_teacher);
        User user = new User(account, pwd,bool_teacher,email);
        HttpSession session = req.getSession();
        try {
            int res = registerDao.register(user);
            if (res > 0) {
                resp.sendRedirect("login_register.jsp");
            } else if (res == 0) {
                //账号已存在
                session.setAttribute("bool_register",1); //返回1作为账号存在的标识
                resp.sendRedirect("login_register.jsp");
            } else {
                session.setAttribute("bool_register",-1); //返回-1表示系统异常
                resp.sendRedirect("login_register.jsp"); //系统异常
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
