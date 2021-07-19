<%--
  Created by IntelliJ IDEA.
  User: White Jiang
  Date: 2020/9/23
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Login and Register</title>
    <link rel="stylesheet" href="login_register.css" type="text/css" />
</head>

<body>
<script language="JavaScript">
    var flag = '<%=request.getSession().getAttribute("flag")%>'; //接收servlet传过来的值
    <%
        request.getSession().removeAttribute("flag");
        session.invalidate();
    %> //从session中去掉flag
    if(flag ==-1){
        alert("密码错误");
    }else if(flag == -2){
        alert("账号不存在");
    }
</script>
<script language="JavaScript">
    var flag = '<%=request.getSession().getAttribute("bool_register")%>';
    <%
        request.getSession().removeAttribute("bool_register");
    %>
    if(flag ===1){
        alert("账号已存在");
    }else if(flag === -2){
        alert("系统异常")
    }
</script>
<div id ="main">
    <div class="header">
        <img src="images/login.png" alt=""/>
        <nav>
            <a href="../index.jsp">返回索引</a>
        </nav>
    </div>
    <div class="middle">
        <img id = "cloud" src="images/background.svg" alt="">
        <form id = "login_form" action="../loginServlet" name="Login_sub" method="post"></form>
        <form id = "register_form" action="../registerServlet" name="Register_sub" method="post"></form>
        <form class="modal-content" >
            <ul class="sidebar">
                <li id="tab1">Login</li>
                <li id="tab2">Register</li>
            </ul>
            <div id="login">
                <div class="container">
                    <label><b>Username</b></label>
                    <label for="Account"></label><input id="Account" type="text" minlength="5" maxlength="10" placeholder="Enter Username" name="account" form="login_form" required />
                    <label><b>Password</b></label>
                    <label for="Pwd"></label><input id = "Pwd" type="password" minlength="5" maxlength="16" placeholder="Enter Password" name="pwd" form="login_form" required />
                    <label><b>Verification Code</b></label>
                    <label for="vc"></label><input id ="vc" type="text"  placeholder="Enter Verification Code" name="vc" form="login_form" required >
                    <canvas
                            id="canvas"
                            onclick="change()"
                    >
                    </canvas>
                    <label for="remember"></label><input id = "remember" type="checkbox" checked="checked" /> Remember me
                    <button type="button" onclick="sign_in()" form="login_form" >Sign In </button>
                </div>
            </div>
            <div id="register">
                <div class="container">
                    <label><b>Username</b></label>
                    <label>
                        <input type="text" name="account" minlength="5" maxlength="10" form = "register_form" placeholder="Enter Username" required/>
                    </label>
                    <label><b>Email</b></label>
                    <label for="Email"></label><input type="text" placeholder="Enter Email" name="email" id="Email" form = "register_form" required />
                    <label><b>Password</b></label>
                    <label>
                        <input type="password" minlength="5" maxlength="16" placeholder="Enter Password" name="pwd" form = "register_form" required />
                    </label>
                    <label>
                        <input type="radio" name="ident" value="0" form = "register_form" checked />
                    </label>Student
                    <label>
                        <input type="radio" name="ident" value="1" form = "register_form"/>
                    </label>Teacher
                    <button type="button" class="register_button" onclick="sign_up()"  form ="register_form">Sign Up</button>
                </div>
            </div>
        </form>
    </div>
    <div class="footer">
        <a  href="">about us</a>
    </div>
</div>
<script  src="js/login_register.js"></script>
<script  src = "js/prepare.js"></script>
</body>
</html>