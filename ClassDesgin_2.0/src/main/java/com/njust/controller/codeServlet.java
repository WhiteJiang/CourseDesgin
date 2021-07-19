package com.njust.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class codeServlet extends HttpServlet {

    @Override //发送邮箱验证码
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String Email = req.getParameter("email");
        HtmlEmail email = new HtmlEmail(); //创建实例对象
        email.setHostName("smtp.qq.com");
        email.setCharset("utf-8");//设置发送的字符类型
        try {
            String code = RandomStringUtils.random(6, "0123456789");; //验证码
            email.addTo(Email);//设置收件人
            email.setFrom("2578208863@qq.com","WhiteJiang");//发送人的邮箱为自己的，用户名
            email.setAuthentication("2578208863@qq.com","upcwtutfhrwwecjb");//设置发送人到的邮箱和授权码
            email.setSubject("VC验证码");//设置发送主题
            email.setMsg(code);//设置发送内容
            email.send();//进行发送
            req.getSession().setAttribute("code",code);
            req.getSession().setAttribute("bool_sure",2); //2表示已发送验证码
            resp.sendRedirect("retrieve_pwd.jsp");
        } catch (EmailException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
