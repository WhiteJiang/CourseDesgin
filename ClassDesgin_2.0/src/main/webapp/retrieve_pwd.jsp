<%--
  Created by IntelliJ IDEA.
  User: White Jiang
  Date: 2020/9/21
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>找回密码</title>
</head>
<body>
    <%
        if(session.getAttribute("bool_sure") ==null ||(int)session.getAttribute("bool_sure") == 0 ||(int)session.getAttribute("bool_sure") == -1){
    %>
    <form action="getAccountServlet" method="post">
        账号：<br>
        <input type="text" placeholder="账号" name="account"><br>
        <input type="submit" value="确定">
    </form>
    <%
        }else if((int)session.getAttribute("bool_sure") == 1){
    %>
    <form action="codeServlet" name="emailForm" method="post">
        请输入你绑定的QQ邮箱：<br>
        <input type="text" placeholder="完整的邮箱" name="email" id="email">
        <input type="button" value="确定" onclick="check()">
    </form>
    <%
        }else if((int)session.getAttribute("bool_sure") ==2 ||(int)session.getAttribute("bool_sure") ==-2){
    %>
        请输入收到的验证码：<br>
    <form action="checkCodeServlet" name="codeForm" >
        验证码：<input type="text" name="Code" id="code">
        <input type="button" value="确定" onclick="checkCode()">
    </form>
    <%
        }else if((int)session.getAttribute("bool_sure") ==3){
    %>
        请输入新密码：<br>
    <form action="modifyPwdServlet" method="post" name="pwdForm">
        密码：<input type="password" maxlength="11" id="pwd" name="pwd">
        <input type="button" value="确定" onclick="checkPwd()">
    </form>
    <%
        }
    %>
    <script language="JavaScript">
        var bool_sure = <%=session.getAttribute("bool_sure")%>;
        if(bool_sure == 0){
            alert("账号不存在");
        }else if(bool_sure == -1){
            alert("系统异常");
        }else if(bool_sure == -2){
            alert("验证码错误");
        }
        var modify = <%=session.getAttribute("modify")%>;
        if(modify == 0){
            alert("密码修改失败");
        }else if(modify ==-1){
            alert("系统异常");
        }
        function check() {
            var email = document.getElementById("email").value;
            if(email === '<%=session.getAttribute("email")%>'){
                document.emailForm.submit();
            }else{
                alert("输入的邮箱错误");
            }
        }
        function checkCode(){
            var code = document.getElementById("code").value;
            if(code.length ===6){
                document.codeForm.submit();
            }else{
                alert("验证码格式错误");
            }
        }
        function checkPwd() {
            var pwdLength = document.getElementById("pwd").value.length;
            if(pwdLength < 8){
                alert("密码过短");
            }else{
                document.pwdForm.submit();
            }
        }
    </script>
</body>
</html>
