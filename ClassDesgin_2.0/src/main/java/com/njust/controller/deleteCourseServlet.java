package com.njust.controller;

import com.njust.dao.deleteCourseDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class deleteCourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int course_id = Integer.parseInt(req.getParameter("course_id"));
        int res = deleteCourseDao.deleteCourse(course_id);
        if(res == 0 || res ==-1){
            req.getSession().setAttribute("bool_delete",res);
            resp.sendRedirect("course_message.jsp");
        }else {
            resp.sendRedirect("myCourseServlet"); //跳转到老师的界面,重新加载
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
