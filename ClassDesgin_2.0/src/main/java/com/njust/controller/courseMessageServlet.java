package com.njust.controller;

import com.njust.dao.courseMessageDao;
import com.njust.entity.Course;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class courseMessageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //学生获取课程信息
        req.setCharacterEncoding("utf-8");
        int course_id = Integer.parseInt(req.getParameter("course_id"));
        Course course = courseMessageDao.courseMessage(course_id);
        req.getSession().setAttribute("Course",course);
        resp.sendRedirect("course_message.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
