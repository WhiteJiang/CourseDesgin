<%--
  Created by IntelliJ IDEA.
  User: White Jiang
  Date: 2020/9/8
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>创建课程</title>
</head>
<body>
<script language="JavaScript">
    var course_flag = '<%=request.getSession().getAttribute("course_flag")%>'; //接收servlet传过来的值
    <% request.getSession().removeAttribute("course_flag"); %> //从session中去掉flag
    if(course_flag == 0){
        alert("创建课程失败");
    }else if(course_flag == -1){
        alert("系统异常");
    }
</script>
    <form action="creatCourseServlet" method="post" >
        课程类别： <input type="text" name="category" > <br/>
        课程名： <input type="text" name="course_name"> <br/>
        课程介绍：<input type="text" name="course_introduce"> <br/>
        <input type="submit" value="创建课程">
    </form>
</body>
</html>
