package com.njust.controller;

import com.njust.dao.remarkDao;
import com.njust.dao.toCourseDao;
import com.njust.entity.CourseRemark;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class remarkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        int id = (int) session.getAttribute("id");
        int course_id = ((CourseRemark) session.getAttribute("signal_course")).getCourse_id();
        double grade = Integer.parseInt(req.getParameter("ident"));
        int res = 0;
        try {
            res = remarkDao.remark(course_id,id,grade);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        CourseRemark signal_course = toCourseDao.toCourse(course_id,id);
        session.setAttribute("signal_course",signal_course);
        session.setAttribute("remark_result",res);
        resp.sendRedirect("home/home.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
