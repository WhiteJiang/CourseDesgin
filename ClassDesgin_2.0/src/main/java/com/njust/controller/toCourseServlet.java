package com.njust.controller;

import com.njust.dao.toCourseDao;
import com.njust.entity.CourseRemark;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class toCourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //获取单个课程信息
        req.setCharacterEncoding("utf-8");
        int id = (int) req.getSession().getAttribute("id");
        int course_id = Integer.parseInt(req.getParameter("course_id"));
        System.out.println("course_id"+course_id);
        CourseRemark res = toCourseDao.toCourse(course_id,id);
        req.getSession().setAttribute("signal_course", res);  //res保存获取的课程结果
        req.getSession().setAttribute("bool_press",1); //需要弹出窗口
        if(req.getParameter("fly") !=null){
            resp.sendRedirect("course_show_student.jsp");
        }else {
            resp.sendRedirect("home/home.jsp"); //跳转到为学生的课程信息展示界面
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
