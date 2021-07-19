package com.njust.controller;

import com.njust.dao.modifyPwdDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class modifyPwdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String pwd = req.getParameter("pwd");
        String account = (String) req.getSession().getAttribute("modifyAccount");
        int res = modifyPwdDao.modifyPwd(pwd,account);
        if(res ==1){
            resp.sendRedirect("login_register.jsp");
        }else{
            req.getSession().setAttribute("modify",res); //用来标识是否更新成功
            resp.sendRedirect("retrieve_pwd.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
