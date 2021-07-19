package com.njust.controller;


import com.njust.entity.Course;
import com.njust.service.courseService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class myCourseServlet extends HttpServlet { //老师查看课程
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();  //通过session获取账号id方便查询数据库
        int teacher_id = (int) session.getAttribute("id");
        int total_course = courseService.countCourse(teacher_id);
        int total_page = (int)Math.ceil((double)total_course/8);
        session.setAttribute("total_page",total_page);
        String to = req.getParameter("To");
        String next = req.getParameter("Next");
        int current_page = 1;
        if(to !=null){
            current_page = (int) session.getAttribute("current_page")-1;
            if(current_page ==0){
                current_page =1;
            }
        }
        if(next!=null){
            current_page = (int) session.getAttribute("current_page")+1;
            if(current_page >total_page){
                current_page =total_page;
            }
        }
        session.setAttribute("current_page",current_page);
        List<Course> result = null;
        try {
            result = courseService.ShowAllCourse(teacher_id,current_page);
            //req.setAttribute("result",result);
            session.setAttribute("result",result);
            //req.getRequestDispatcher("personal_center.jsp").forward(req,resp);
            resp.sendRedirect("personal_center.jsp");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
