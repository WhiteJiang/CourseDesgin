package com.njust.controller;

import com.njust.dao.updateCourseDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class updateCourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String course_introduce = req.getParameter("introduce");
        int course_id = Integer.parseInt(req.getParameter("course_id"));
        int res = updateCourseDao.updateCourse(course_id,course_introduce);
        req.getSession().setAttribute("updateCourse",res);
        if(res ==0||res==-1){
            resp.sendRedirect("course_message.jsp");
        }else if(res==1){
            resp.sendRedirect("personal_center.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
