package com.njust.controller;

import com.njust.dao.searchDao;
import com.njust.entity.Course;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class searchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String input = (String) req.getSession().getAttribute("key");
        try {
            Course res = searchDao.search((int)req.getSession().getAttribute("bool_search"),input);
            if(res!= null){
                req.getSession().setAttribute("if_get",1); //1表示获取到搜索结果
                resp.sendRedirect(""); //跳转到课程展示界面
            }
            else{
                req.getSession().setAttribute("if_get",0); //0表示未获取到搜索结果
                resp.sendRedirect(""); //跳转到课程展示界面
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
