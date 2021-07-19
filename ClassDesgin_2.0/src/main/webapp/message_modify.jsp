<%--
  Created by IntelliJ IDEA.
  User: White Jiang
  Date: 2020/9/16
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<script language="JavaScript">
    var bool_modify = '<%=session.getAttribute("bool_modify")%>';
    if(bool_modify == 0){
        alert("修改失败");
    }else if(bool_modify == -1){
        alert("系统异常");
    }
    <%session.removeAttribute("bool_modify");%>
</script>
<form action="modifyStudentMessageServlet" name="modifyForm" method="post">
    <div>
        电话：<input type="text" name="phone" id = "Phone" placeholder="<%=session.getAttribute("phone")%>" onkeyup="value=value.replace(/[^(\d)]/g,'')" maxlength="11" onfocusout ="check('Phone')">
        <div id="one">请输入电话</div>
    </div>
    <div >
        邮箱：<input type="text" name="email" id="Email" placeholder="<%=session.getAttribute("email")%>" maxlength="18" onfocusout="check('Email')">
        <div id="two">请输入邮箱</div>
    </div>
    <div>
        名字：<input type="text" name="name" id ="Name" placeholder="<%=session.getAttribute("name")%>" maxlength="14" onfocusout="check('Name')">
        <div id="three">请输入名字</div>
    </div>
    <input type="button" value="修改" onclick="countNum()" id="btn">
</form>
<script language="JavaScript">
    function bool_email(a) {
        var length = a.length;
        var string = a.substring(length-7,length);
        var stringEmail = '@qq.com';
        var stringEmail1 = '@QQ.com';
        if(string == stringEmail || string == stringEmail1){
            return true;
        }else{
            return false;
        }
    }
    function check(ID) {
        switch (ID) {
            case"Phone":
                var lengthPhone = document.getElementById('Phone').value.length;
                var divPhone = document.getElementById('one');
                if (lengthPhone > 0 && lengthPhone < 11) {
                    divPhone.innerHTML = '×';
                    divPhone.style.display = 'red';
                } else if(lengthPhone == 11){
                    divPhone.innerHTML = '√';
                    divPhone.style.display = '#18fd1d';
                }
                break;
            case "Email":
                var lengthEmail = document.getElementById('Email').value.length;
                var divEmail = document.getElementById('two');
                var bool = bool_email( document.getElementById('Email').value);
                if(lengthEmail > 14 && bool){
                    divEmail.innerHTML = '√';
                }else if(lengthEmail <= 14 && lengthEmail > 0){
                    divEmail.innerHTML = 'x';
                }else{
                    divEmail.innerHTML ='请输入密码';
                }
                break;
            case "Name":
                var lengthName = document.getElementById('Name').value.length;
                var divName = document.getElementById('three');
                if(lengthName > 0){
                    divName.innerHTML = '√';
                    divName.style.display = '#18fd1d';
                }
                break;
            default :break;
        }
    }
    function countNum() {
        var lengthPhone = document.getElementById('Phone').value.length;
        var lengthEmail = document.getElementById('Email').value.length;
        var lengthName = document.getElementById('Name').value.length;
        if(lengthEmail > 14 && bool_email(document.getElementById('Email').value) &&lengthPhone == 11){ //提交条件
            //document.getElementById('btn').disabled = true;  //为true时提交
            document.modifyForm.submit();
        }
        else{
            if(lengthPhone < 11){
                alert("电话号码错误");
            }else if(lengthEmail < 14 || bool_email(document.getElementById('Email').value) == false){
                alert("请输入正确的邮箱")
            }else if (lengthName ==0){
                alert("请输入名字");
            }
        }
    }
</script>
</body>
</html>
