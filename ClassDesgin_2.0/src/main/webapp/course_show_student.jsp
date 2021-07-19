<%@ page import="com.njust.entity.Course" %>
<%@ page import="com.njust.entity.CourseRemark" %><%--
  Created by IntelliJ IDEA.
  User: White Jiang
  Date: 2020/9/20
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程信息展示</title>
</head>
<body>
    课程名：<input type="text"  name="course_name" disabled value=<%=((CourseRemark)session.getAttribute("signal_course")).getCourse_name()%>  ><br>
    教师：<input type="text"  name="course_name" disabled value=<%=((CourseRemark)session.getAttribute("signal_course")).getTeacher()%>  ><br>
    课程介绍：<input type="text"  name="course_name" disabled value=<%=((CourseRemark)session.getAttribute("signal_course")).getCourse_introduce()%>  ><br>
    评价人数：<input type="text"  name="course_name" disabled value=<%=((CourseRemark)session.getAttribute("signal_course")).getTotal_evaluate_numb()%>  ><br>
    课程评分：<input type="text"  name="course_name" disabled value=<%=((CourseRemark)session.getAttribute("signal_course")).getGrade()%>  ><br>
    <%
        //不-1代表学生已加入课程
        if (((CourseRemark)session.getAttribute("signal_course")).getBool_remark()!=-1){
    %>
    <form action="studyServlet" name="studyForm" method="post">
        <input type="hidden" name="course_id" value=<%=((CourseRemark)session.getAttribute("signal_course")).getCourse_id()%>>
        <input type="hidden" name="chapter_id" value="1">
        <input type="submit"  value="开始学习"><br>
    </form>
    <form action="exitCourseServlet" method="post">
        <input type="submit" value="退出课程">
    </form>
    <%
        }
    %>
    <%
        //-1表示学生未加入该课程
        if (((CourseRemark)session.getAttribute("signal_course")).getBool_remark() == -1 ){
    %>
    <form action="addCourseServlet" method="post">
        <input type="submit" value="加入课程"><br>
    </form>
    <%
        }
    %>
    <%
        //为0来表示学生未评价该课程
        if (((CourseRemark)session.getAttribute("signal_course")).getBool_remark() == 0){
    %>
    <form action="remarkServlet" name="remarkForm" method="post">
        <div id="remark">
            评价课程:<br>
            <input type="radio" name="ident" value="1" checked>1.0
            <input type="radio" name="ident" value="2" >2.0
            <input type="radio" name="ident" value="3" >3.0
            <input type="radio" name="ident" value="4" >4.0
            <input type="radio" name="ident" value="5" >5.0
        </div>
        <input type="button" value="提交" onclick="remark()" id="btn">
    </form>
    <%
        }
    %>
    <%
        //1来表示学生已评价该课程
        if (((CourseRemark)session.getAttribute("signal_course")).getBool_remark()==1){
    %>
        <input type="button" value="已评价" disabled><br>
        <input type="text" value=<%=((CourseRemark)session.getAttribute("signal_course")).getGrade()%>>
    <%
        }
    %>
    <script language="JavaScript">
        function remark() {
            var radio = document.getElementsByName('ident');
            var a; //存储结果
            for ( var i = 0; i < 5 ;i++){
                if(radio[i].checked){
                    a = radio[i].value;
                }
            }
            document.remarkForm.submit();
        }
        var remark_result = <%=session.getAttribute("remark_result")%>;
        if(remark_result == 0){
            alert("更新失败");
        }else if(remark_result ==-1){
            alert("系统异常");
        }
        var bool_add = <%=session.getAttribute("bool_add")%>;
        if(bool_add == 0){
            alert("添加失败");
        }else if(bool_add ==-1){
            alert("系统异常");
        }
        var bool_exit = <%=session.getAttribute("bool_exit")%>;
        if(bool_exit == 0){
            alert("添加失败");
        }else if(bool_exit ==-1){
            alert("系统异常");
        }
    </script>
</body>
</html>
