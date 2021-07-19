<%@ page import="com.njust.entity.Course" %><%--
  Created by IntelliJ IDEA.
  User: White Jiang
  Date: 2020/9/16
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程信息</title>
</head>
<body>
<div class="choose">
    <a  class="aLink" href="creat_course.jsp">创建课程</a>
    <a  class="aLink" href="personal_center.jsp">个人中心</a>
    <a  class="aLink" href="message_modify.jsp">设置</a>
    <a  class="aLink" href="loginOutServlet">退出</a>
</div>
<form action="updateCourseServlet" method="post" >
    课程名<input type="text" disabled value=<%=((Course)session.getAttribute("Course")).getCourse_name()%>><br>
    课程类别<input type="text"  disabled value=<%=((Course)session.getAttribute("Course")).getCategory()%>><br>
    课程介绍<input type="text" name="introduce" placeholder=<%=((Course)session.getAttribute("Course")).getCourse_introduce()%>><br>
    创建时间<input type="text" disabled value=<%=((Course)session.getAttribute("Course")).getCreatTime()%>><br>
    总评价人数<input type="text" disabled value=<%=((Course)session.getAttribute("Course")).getTotal_evaluate_numb()%>><br>
    评分<input type="text"  disabled value=<%=((Course)session.getAttribute("Course")).getGrade()%>><br>
    <input type="hidden" name="course_id" value=<%=((Course)session.getAttribute("Course")).getCourse_id()%>>
    <input type="submit" value="修改课程信息">
</form>
<form action="getCourseIdChapterServlet" method="post">
    <input type="hidden" name="course_id" value=<%=((Course)session.getAttribute("Course")).getCourse_id()%>>
    <input type="submit" value="上传课件">
</form>
<form action="deleteCourseServlet" method="post">
    <input type="hidden" name="course_id" value=<%=((Course)session.getAttribute("Course")).getCourse_id()%>>
    <input type="submit" value="删除课程">
</form>
<script language="JavaScript">
    var flag =-2;
    var bool_delete = -2;
    flag = <%=session.getAttribute("updateCourse")%>;
    if(flag === 0){
        alert("更新失败");
    }else if(flag === -1){
        alert("系统异常");
    }
    bool_delete = <%=session.getAttribute("bool_delete")%>;
    if(bool_delete === 0){
        alert("删除失败！");
    }else if(bool_delete === -1){
        alert("系统异常！");
    }
</script>
</body>
</html>
