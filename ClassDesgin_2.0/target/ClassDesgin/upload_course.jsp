<%@ page import="com.njust.entity.CourseBigChapter" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: White Jiang
  Date: 2020/9/21
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传课件</title>
</head>
<body>
<%
    List<CourseBigChapter> courses = null;
    int l=0;
    int course_id = (int) session.getAttribute("course_id");
    if(session.getAttribute("CourseBigChapter") !=null){
        courses = (List<CourseBigChapter>) session.getAttribute("CourseBigChapter");
        l =courses.size();
    }
%>
<%
    CourseBigChapter course=null;
    for (int i = 0; i<l; i++){
        course = courses.get(i);
%>
<div class="choose">
    <a  class="aLink" href="creat_course.jsp">创建课程</a>
    <a  class="aLink" href="personal_center.jsp">个人中心</a>
    <a  class="aLink" href="message_modify.jsp">设置</a>
    <a  class="aLink" href="loginOutServlet">退出</a>
</div>
<div>
    <input type="text" name="chapter_id"  disabled value="第<%=course.getCourse_chapter_id()%>章： <%=course.getChapter_name()%>"><br>
</div>
<%
    }
%>
    <input type="button" value="添加课件" id="btn" onclick="add()">
<form action="uploadCourseServlet" method="post" encType="multipart/form-data" name="uploadForm" id="upload" style="display: none">
    <div>
        第<%=l+1%>章：<input type="text" id="chapterName" name="chapter_name"><br>
        选择课件:<input type="file"  id="upload_file" name="uploadFile">
        <input type="hidden" id="chapterId" name="chapter_id" value=<%=l+1%>>
        <input type="hidden" id="courseId" name="course_id" value=<%=course_id%>>
    </div>
</form>
<script language="JavaScript">
    var bool_upload = 0;
    bool_upload =<%=session.getAttribute("bool_upload")%>;
    if(bool_upload === -1){
        alert("系统异常");
    }else if(bool_upload == 0){
        alert("上传失败");
    }
    function add() {
        var value = document.getElementById("btn").value;
        if(value === "添加课件"){
            document.getElementById("upload").style.display ="block";
            document.getElementById("btn").value ="上传"
        }else if(value === "上传"){
            document.uploadForm.submit();
        }
    }
</script>
</body>
</html>
