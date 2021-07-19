package com.njust.controller;

import com.njust.dao.addCourseDao;
import com.njust.dao.toCourseDao;
import com.njust.entity.CourseRemark;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class addCourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        int id = (int) session.getAttribute("id");
        int course_id = ((CourseRemark) session.getAttribute("signal_course")).getCourse_id();
        System.out.println(course_id);
        int res = addCourseDao.addCourse(id,course_id);
        System.out.println(res);
        if(res>0) {
            CourseRemark signal_course = toCourseDao.toCourse(course_id, id);
            session.setAttribute("signal_course",signal_course);
        }
        session.setAttribute("bool_add",res);//bool_add标识是否添加成功
        resp.sendRedirect("home/home.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
