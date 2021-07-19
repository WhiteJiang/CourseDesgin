package com.njust.controller;
import com.njust.dao.getCourseDao;
import com.njust.entity.Course;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class getCourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {  //主页展示课程
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        int total_course = getCourseDao.countNum();
        int total_page = (int)Math.ceil((double)total_course/8);
        session.setAttribute("total_page",total_page);
        String to = req.getParameter("To");
        String next = req.getParameter("Next");
        int current_page = 1;
        if(to !=null){
            current_page = (int) session.getAttribute("student_current_page")-1;
            if(current_page ==0){
                current_page =1;
            }
        }
        if(next!=null){
            current_page = (int) session.getAttribute("student_current_page")+1;
            if(current_page >total_page){
                current_page =total_page;
            }
        }
        List<Course> courses = getCourseDao.getAllCourse(current_page);
        session.setAttribute("student_current_page",current_page);//学生当前主页所在页
        session.setAttribute("allCourse",courses); //将向学生展示的所有课程
        session.setAttribute("chooseValue",0); //设置标视，用来判断需要展示的课程类型 0表示展示全部类型的课程
        session.setAttribute("bool_press",0); //设置标签，判断是否需要弹出窗口
        resp.sendRedirect("home/home.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
