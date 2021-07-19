package com.njust.controller;

import com.njust.dao.creatCourseDao;
import com.njust.entity.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class creatCourseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //老师创建课程
        req.setCharacterEncoding("utf-8");
        String category = req.getParameter("category");
        String teacher = (String) req.getSession().getAttribute("name");
        String course_name = req.getParameter("course_name");
        String course_introduce = req.getParameter("course_introduce");
        double grade = 0;
        int total_evaluate_numb = 0;
        long time = System.currentTimeMillis();
        HttpSession session = req.getSession();
        java.sql.Timestamp creatTime = new java.sql.Timestamp(time);
        int teacher_id = (int) session.getAttribute("id");
        Course course = new Course(category, creatTime, teacher, course_name,course_introduce, teacher_id, total_evaluate_numb,  grade);
        try{
            int res = creatCourseDao.creatCourse(course);
            if (res > 0) {
                resp.sendRedirect("personal_center.jsp");
            } else if (res == 0) {  //创建失败
                req.getSession().setAttribute("course_flag",0);
                resp.sendRedirect("creat_course.jsp");
            } else {
                req.getSession().setAttribute("course_flag",-1);
                resp.sendRedirect("creat_course.jsp");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


}
