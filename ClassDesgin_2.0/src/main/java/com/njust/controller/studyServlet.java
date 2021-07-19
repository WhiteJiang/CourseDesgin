package com.njust.controller;

import com.njust.dao.studyDao;
import com.njust.entity.CourseBigChapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class studyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //跳转到学习界面时展示给学生看课程
        req.setCharacterEncoding("utf-8");
        int course_id = Integer.parseInt(req.getParameter("course_id"));
        int chapter_id = 1;//Integer.parseInt(req.getParameter("chapter_id"));
        List<CourseBigChapter> courseBigChapters = studyDao.study(course_id);
        req.getSession().setAttribute("courseChapter",courseBigChapters);
        req.getSession().setAttribute("chapter_id",chapter_id);
        resp.sendRedirect("study/study.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
