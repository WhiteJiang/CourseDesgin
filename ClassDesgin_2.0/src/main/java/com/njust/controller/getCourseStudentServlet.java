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

//根据学生选择获取课程
public class getCourseStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //根据value展示不同课程;
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        int value = Integer.parseInt(req.getParameter("chooseCourse"));
        if(value == 1){
            int total_course = getCourseDao.countNum("计算机");
            int total_page = (int)Math.ceil((double)total_course/8);
            session.setAttribute("total_page",total_page);
            String to = req.getParameter("To");
            String next = req.getParameter("Next");
            int current_page = 1;
            if(to !=null){
                current_page = (int) session.getAttribute("computer_current_page")-1;
                if(current_page ==0){
                    current_page =1;
                }
            }
            if(next!=null){
                current_page = (int) session.getAttribute("computer_current_page")+1;
                if(current_page >total_page){
                    current_page =total_page;
                }
            }
            session.setAttribute("computer_current_page",current_page);
            List<Course> courses =getCourseDao.getCourse("计算机",current_page);
            req.getSession().setAttribute("computer",courses);
            req.getSession().setAttribute("chooseValue",1); //1表示展示计算机课课程
            resp.sendRedirect("home/home.jsp");
        }else{
            int total_course = getCourseDao.countNum("高数");
            int total_page = (int)Math.ceil((double)total_course/8);
            String to = req.getParameter("To");
            String next = req.getParameter("Next");
            int current_page = 1;
            if(to !=null){
                current_page = (int) session.getAttribute("math_current_page")-1;
                if(current_page ==0){
                    current_page =1;
                }
            }
            if(next!=null){
                current_page = (int) session.getAttribute("math_current_page")+1;
                if(current_page >total_page){
                    current_page =total_page;
                }
            }
            session.setAttribute("math_current_page",current_page);
            List<Course> courses =getCourseDao.getCourse("高数",current_page);
            req.getSession().setAttribute("math",courses);
            req.getSession().setAttribute("chooseValue",2); //展示高数课程
            resp.sendRedirect("home/home.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
