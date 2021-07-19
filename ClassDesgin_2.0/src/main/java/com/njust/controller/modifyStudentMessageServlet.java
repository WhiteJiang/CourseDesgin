package com.njust.controller;

import com.njust.dao.modifyStudentMessageDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class modifyStudentMessageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session =req.getSession();
        int id = (int) session.getAttribute("id");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        int bool_teacher = (int) session.getAttribute("bool_teacher");
        int res = modifyStudentMessageDao.modifyStudentMessage(id,bool_teacher,phone,email,name);
        if(res == 1){
            session.setAttribute("phone",phone);
            session.setAttribute("email",email);
            session.setAttribute("name",name);
            resp.sendRedirect("personal_center.jsp");
        }else if(res ==0){
            session.setAttribute("bool_modify",0);
            resp.sendRedirect("message_modify.jsp");
        }else{
            session.setAttribute("bool_modify",-1);
            resp.sendRedirect("message_modify.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
