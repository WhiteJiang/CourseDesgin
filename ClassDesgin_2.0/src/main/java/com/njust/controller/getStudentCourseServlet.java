package com.njust.controller;

import com.njust.dao.myCourseStudentDao;
import com.njust.entity.Course;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class getStudentCourseServlet extends HttpServlet {//获取学生已加入课程
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id = (int) req.getSession().getAttribute("id");
        List<Course> res = myCourseStudentDao.myCourseStudent(id);
        req.getSession().setAttribute("studentCourse",res);
        resp.sendRedirect("student_center.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
