<%@ page import="com.njust.entity.CourseBigChapter" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: White Jiang
  Date: 2020/9/22
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Study</title>
    <link href="study.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="header">
    <img src="../login_register/images/login.png" />
    <nav><a href="">个人中心</a>&nbsp;&nbsp;&nbsp;<a href="../home/home.jsp">主页</a></nav>
</div>
<div class="chapter">
    <%
        List<CourseBigChapter> courses = null;
        int l=0;
        int index = (int) session.getAttribute("chapter_id")-1;
        if(session.getAttribute("courseChapter") !=null){
            courses = (List<CourseBigChapter>) session.getAttribute("courseChapter");
            l =courses.size();
        }
    %>
    <%
        CourseBigChapter course=null;
        for (int i = 0; i<l; i++){
            course = courses.get(i);
    %>
    <form action="../changeServlet"  name="chapterForm"  method="post">
        <input type="submit"   name="chapter_name" value="第<%=course.getCourse_chapter_id()%>章：<%=course.getChapter_name()%>" >
        <input type="hidden" name="chapter_id" value=<%=course.getCourse_chapter_id()%>>
    </form>
    <%
        }
    %>
</div>
<div class="video">
    <video  controls="controls" src=../<%=(courses.get(index)).getCourse_address()%> ></video>
    <br/>
    <div style="width: 55%;float: left">
        <button style="float: right;margin-top: 10px">上一章</button>
    </div>
    <div style="width: 45%;float: right">
        <button style="float: left;margin-top: 10px">下一章</button>
    </div>
</div>

<script>

</script>
</body>
</html>
