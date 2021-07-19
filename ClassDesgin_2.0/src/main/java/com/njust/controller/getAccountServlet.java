package com.njust.controller;

import com.njust.dao.getAccountDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class getAccountServlet extends HttpServlet { //获取账号 用于找回密码的账号确认
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String account = req.getParameter("account");
        String email = getAccountDao.getAccount(account);
        if(email!=null){
            req.getSession().setAttribute("bool_sure",1); //1表示账号已确认
        }else {
            assert false;
            if(email.equals("error")){
                req.getSession().setAttribute("bool_sure",-1); //-1系统异常
            }
            else {
                req.getSession().setAttribute("bool_sure",0); //0表示账号不存在
            }
        }
        req.getSession().setAttribute("email",email);
        req.getSession().setAttribute("modifyAccount",account); //需要修改密码的账户
        resp.sendRedirect("retrieve_pwd.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
