package com.njust.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class checkCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String code = (String) req.getSession().getAttribute("code");
        String inputCode = req.getParameter("Code");
        if(code.equals(inputCode)){
            req.getSession().setAttribute("bool_sure",3); //表示可以去设置新密码
        }else{
            req.getSession().setAttribute("bool_sure",-2); //-2表示验证码错误
        }
        resp.sendRedirect("retrieve_pwd.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
