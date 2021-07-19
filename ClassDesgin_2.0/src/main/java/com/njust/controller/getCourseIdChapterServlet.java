package com.njust.controller;

import com.njust.dao.getCourseIdChapterDao;
import com.njust.entity.CourseBigChapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class getCourseIdChapterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int course_id = Integer.parseInt(req.getParameter("course_id"));
        List<CourseBigChapter> res = getCourseIdChapterDao.getCourseIDChapter(course_id);
        req.getSession().setAttribute("course_id",course_id); //设置课程id，便于提交课件
        req.getSession().setAttribute("CourseBigChapter",res);
        resp.sendRedirect("upload_course.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
