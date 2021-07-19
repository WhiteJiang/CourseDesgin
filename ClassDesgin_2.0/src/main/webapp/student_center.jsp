<%@ page import="com.njust.entity.Course" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: White Jiang
  Date: 2020/9/16
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        .showImage{
            width: 150px;
            height: 100px;
            border-radius: 5px 5px 0px 0px;
        }
        .searchLine{
            display: inline-block;
        }


        .Course{
            width: 150px;
            height: 180px;
            display: inline-block;
            background-color: white;
            border-radius: 5px;
        }

        .Course input[type="text"]{
            border: 0px;
            background-color: white;
            width: 130px;
        }

        .Course input[type="text"]:first-of-type{
            margin-top: 10px;
            font-size: small;
        }

        .Course input[type="text"]:nth-of-type(2){
            font-size:smaller;
            color: gray;
        }

        .Course input[type="submit"] {
            width: 150px;
            height: 180px;
            background-color: transparent;
            border: 0px;
            border-radius: 5px;
            position: relative;
            top: -153px;
        }

        .Course input[type="submit"]:hover{
            box-shadow:0 0 5px #ccc;
            border-color:#fff;
            background:transparent;
            border-radius: 5px 5px 0px 0px;
        }

        .Course input[type="submit"]:focus{
            outline: 0;
        }
    </style>
    <title>个人中心</title>
</head>
<body>
<script type="text/javascript">
    function toSearch() {
        <%request.getSession().setAttribute("bool_search",1);%>
        window.location.href = "searchServlet";
    }
</script>
<div class="choose">
    <a  class="aLink" href="getStudentCourseServlet">个人中心</a>
    <a  class="aLink" href="message_modify.jsp">设置</a>
    <a  class="aLink" href="loginOutServlet">退出</a>
    <div class="searchLine">
        <input type="text" id="txt">
        <button type="button" id="btn" onclick="toSearch()">search</button>
    </div>
</div>
<div class="personMessage">
    <img src="pictures/headImage.JPG" class="Image">
    <div class="textShow">
        <div class="text"><%=request.getSession().getAttribute("name")%></div>
        <div>学生</div>
    </div>
</div>
<div class="courseShow">
    <div class="courses">我的课程
            <%
                List<Course> courses = null;
                int l=0;
                if(session.getAttribute("studentCourse") !=null){
                    courses = (List<Course>) session.getAttribute("studentCourse");
                    l =courses.size();
                }
                Course course=null;
                for (int i = 0; i<l; i++){
                    course = courses.get(i);
            %>
        <div style="display: inline-block;" >
            <form action="toCourseServlet" class="Course" method="post"  id="formCourse">
                <img src="pictures/headImage.JPG" class="showImage" >
                <input type="text"  disabled name="course_name" value=<%=course.getCourse_name()%>>
                <input type="text" disabled name="grade" value=<%=course.getGrade()%>  >
                <input type="hidden"  name="course_id" value=<%=course.getCourse_id()%> >
                <input type="hidden" name="fly" value="1">
                <input type="submit" value=" " >
            </form>
        </div>
            <%
                }
            %>
    </div>
</div>
</body>
</html>
