<%@ page import="com.njust.entity.Course" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: White Jiang
  Date: 2020/9/9
  Time: 8:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    pageEncoding="utf-8" isELIgnored="false"
%>
<html>
<head>
    <title>个人中心</title>
    <style>
        .choose{
            width: auto;
            height: 63px;
            background: white;
        }
        .aLink {
            height: 105px;
            width: 26px;
            background: white;
            text-decoration:none; //去掉默认下滑线
            color:#333; //设置默认颜色
        }
        .personMessage{
            height: 228px;
            background: #50D58A;
        }
        .Image{
            width:110px;
            height: 110px;
            display: flex;
            border-radius:50%;
            align-items: center;
            justify-content: center;
            overflow: hidden;
            display: inline-block;
        }
        .textShow{
            display: inline-block;
            width: 200px;
            height: 250px;
        }
        .text{
        }
        .courseShow{
            width: auto;
            height: 500px;
        }
        .Show{
            width: 150px;
            height: 200px;
            border-color: red;
            display: inline-block;
        }
        .showImage{
            width: 150px;
            height: 150px;
        }
    </style>
</head>
<body>
<script language="JavaScript">
    function toCourse() {
        var formCourse = document.getElementById('formCourse');
        document:formCourse.submit();
    }
</script>
<%
    List<Course> courses = null;
    int l=0;
    if(session.getAttribute("result") !=null){
        courses = (List<Course>) session.getAttribute("result");
        l =courses.size();
    }
%>
<div class="choose">
        <a  class="aLink" href="creat_course.jsp">创建课程</a>
        <a  class="aLink" href="personal_center.jsp">个人中心</a>
        <a  class="aLink" href="message_modify.jsp">设置</a>
        <a  class="aLink" href="loginOutServlet">退出</a>
</div>

<div class="personMessage">
    <img src="pictures/headImage.JPG" class="Image">
    <div class="textShow">
        <div class="text"><%=request.getSession().getAttribute("name")%></div>
        <div>老师</div>
    </div>
</div>

<div class="courseShow">
    <div>全部课程:</div>
    <%
        Course course=null;
        for (int i = 0; i<l; i++){
             course = courses.get(i);
    %>
    <form action="courseMessageServlet" class="Show" method="post" onclick="toCourse()" id="formCourse">
        <img src="pictures/headImage.JPG" class="showImage" >
        <input type="text"  name="course_name" disabled value=<%=course.getCourse_name()%>  >
        <input type="text" name="grade" disabled value=<%=course.getGrade()%>  >
        <input type="hidden"  name="course_id" value=<%=course.getCourse_id()%> >
        <input type="submit" value="查看课程">
    </form>
    <%
        }
    %>
</div>
    <div>
        <form action="myCourseServlet" method="post" name="form1">
            <input value="上一页" id="to" type="submit" name="To" style="display: inline-block">
        </form>

        <textarea disabled style="display: inline-block"><%=session.getAttribute("current_page")%></textarea>

        <form action="myCourseServlet" method="post" name="form2">
            <input value="下一页" id="next" name="Next" type="submit" style="display: inline-block">
        </form>
    </div>
</body>
</html>