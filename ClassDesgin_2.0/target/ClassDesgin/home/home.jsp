<%@ page import="com.njust.entity.Course" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.concurrent.Callable" %>
<%@ page import="com.njust.entity.CourseRemark" %><%--
  Created by IntelliJ IDEA.
  User: White Jiang
  Date: 2020/9/16
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Home</title>
    <script type="text/javascript" src="js/myfocus-2.0.1.min.js"></script>
    <link href="home.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
        myFocus.set({
            id: 'banner', //ID
            pattern: 'mF_kdui' //风格
        });
    </script>
</head>
<body>
<script src="../header.js" type="text/javascript"></script>
<div class="middle">
    <div class="left">
        <div class="pos">
            <form action="../getCourseServlet" method="post">
                <input type="hidden" name="chooseCourse" value="0"/>
            <button type="submit">全部课程</button>
            </form>
            <form action="../getCourseStudentServlet" method="post">
                <input type="hidden" name="chooseCourse" value="1"/>
            <button type="submit">计算机<span>前沿技术/软件工程/人工智能</span></button>
            </form>
            <form action="../getCourseStudentServlet" method="post">
                <input type="hidden" name="chooseCourse" value="2"/>
                <button>高数<span>前沿技术/软件工程/人工智能</span></button>
            </form>
        </div>
    </div>
    <div id="banner">
        <div class="loading"><img src="images/loading.gif" alt="请稍候..." /></div>
        <div class="pic">
            <ul>
                <li>
                    <a href="#1"><img src="images/course1.png" /></a>
                </li>
                <li>
                    <a href="#2"><img src="images/course2.jpg" /></a>
                </li>
                <li>
                    <a href="#3"><img src="images/course3.png" /></a>
                </li>
                <li>
                    <a href="#4"><img src="images/course4.png" /></a>
                </li>
                <li>
                    <a href="#5"><img src="images/course5.png" /></a>
                </li>
            </ul>
        </div>
    </div>
    <div class="right">
        <p>
            <img src="images/head.png" alt="" />
        </p>
        <form action="../getStudentCourseServlet" method="post">
        <p>
            <button type="submit">个人中心</button>
        </p>
        <p class="tips">由高俊尧、蒋鑫提供</p>
        </form>
    </div>
</div>
<%
    if((int)session.getAttribute("chooseValue") == 0){
%>

<div class="show">
    <p>全部课程</p>
    <%
        List<Course> allCourse = null;
        int la = 0;
        if(session.getAttribute("allCourse")!=null){
            allCourse = (List<Course>)session.getAttribute("allCourse");
            la = allCourse.size();
        }
        Course courses = null;
        for (int i = 0;i<la;i++){
            courses = allCourse.get(i);
    %>
    <div style="display: inline-block;" >
        <form action="../toCourseServlet" class="Course" method="post"  id="formCourse" >
            <img src="../pictures/headImage.JPG" class="showImage" >
            <input type="text"  disabled name="course_name" value=<%=courses.getCourse_name()%>>
            <input type="text" disabled name="grade" value=<%=courses.getGrade()%>  >
            <input type="hidden"  name="course_id" value=<%=courses.getCourse_id()%> >
            <input type="submit" value=" " >
        </form>
    </div>
    <%
        }
    %>
    <br/>
    <div class="page">
        <form action="../getCourseServlet" method="post" name="form1" >
            <input value="上一页" id="to" type="submit" name="To" style="display: inline-block">
        </form>
        <input disabled  value=<%=session.getAttribute("student_current_page")%> >
        <form action="../getCourseServlet" method="post" name="form2" >
            <input value="下一页" id="next" name="Next" type="submit" style="display: inline-block">
        </form>
    </div>
</div>
<%
}else if((int)session.getAttribute("chooseValue") == 1){ //展示计算机课程
%>
<div class="show">
    <div>
        <p>计算机</p>
        <%
            List<Course> courses = null;
            int l=0;
            if(session.getAttribute("computer") !=null){
                courses = (List<Course>) session.getAttribute("computer");
                l =courses.size();
            }
        %>
        <%
            Course course=null;
            for (int i = 0; i<l; i++){
                course = courses.get(i);
        %>
        <div style="display:inline-block">
        <form action="../toCourseServlet" class="Course" method="post" id="formCourse1">
            <img src="../pictures/headImage.JPG" class="showImage" >
            <input type="text"  disabled name="course_name" value=<%=course.getCourse_name()%>>
            <input type="text" disabled name="grade" value=<%=course.getGrade()%>  >
            <input type="hidden"  name="course_id" value=<%=course.getCourse_id()%> >
            <input type="submit" value=" ">
        </form>
        </div>
        <%
            }
        %>
        <br/>
        <div class="page">
            <form action="../getCourseStudentServlet" method="post" name="form1">
                <input value="上一页"  type="submit" name="To" style="display: inline-block">
                <input type="hidden" name="chooseCourse" value="1">
            </form>
            <input disabled  value=<%=session.getAttribute("student_current_page")%> >
            <form action="../getCourseStudentServlet" method="post" name="form2">
                <input value="下一页" name="Next" type="submit" style="display: inline-block">
                <input type="hidden" name="chooseCourse" value="1">
            </form>
        </div>
    </div>
        <%
    }else if((int)session.getAttribute("chooseValue") == 2){ //高数课程
%>
    <div class="show">
        <div>
            <p>高数</p>
            <%
                List<Course> coursesMath = null;
                int lM=0;
                if(session.getAttribute("math") !=null){
                    coursesMath = (List<Course>) session.getAttribute("math");
                    lM =coursesMath.size();
                }
            %>
            <%
                Course courseMath=null;
                for (int i = 0; i<lM; i++){
                    courseMath = coursesMath.get(i);
            %>
            <div style="display: inline-block">
            <form action="../toCourseServlet" class="Course" method="post"  id="formCourse2">
                <img src="../pictures/headImage.JPG" class="showImage" >
                <input type="text"  name="course_name"  disabled value=<%=courseMath.getCourse_name()%> >
                <input type="text" name="grade" disabled value=<%=courseMath.getGrade()%> >
                <input type="hidden"  name="course_id" value=<%=courseMath.getCourse_id()%> >
                <input type="submit" value=" ">
            </form>
            </div>
            <%
                }
            %>
            <br/>
            <div class="page">
                <form action="../getCourseStudentServlet" method="post" name="form1">
                    <input value="上一页"   type="submit" name="To" style="display: inline-block">
                    <input type="hidden" name="chooseCourse" value="2">
                </form>
                <input disabled  value=<%=session.getAttribute("student_current_page")%> >
                <form action="../getCourseStudentServlet" method="post" name="form2">
                    <input value="下一页"  name="Next" type="submit" style="display: inline-block">
                    <input type="hidden" name="chooseCourse" value="2">
                </form>
            </div>
        </div>
    </div>
    <%
        if((int)session.getAttribute("math_current_page") ==1){
    %>
    <script language="JavaScript" type="text/javascript">
        document.getElementsByName("To").disable = false;
    </script>
    <%
        }
    %>
     <%
        }
     %>
    <div id="id01" class="modal" >
        <div class="modal-content animate" >
            <div class="imgcontainer">
                <!--此元素不会被显示-->
                <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
            </div>
            <div class="container">
                <!--课程名-->
             <%if(session.getAttribute("signal_course")!=null){%>
                <input type="text"  name="course_name" disabled value=<%=((CourseRemark)session.getAttribute("signal_course")).getCourse_name()%>>
                <input type="text"  name="course_name" disabled value=<%=((CourseRemark)session.getAttribute("signal_course")).getTeacher()%>  >
                <input type="text"  name="course_name" disabled value=<%=((CourseRemark)session.getAttribute("signal_course")).getCourse_introduce()%>  >
                <input type="text"  name="course_name" disabled value=<%=((CourseRemark)session.getAttribute("signal_course")).getTotal_evaluate_numb()%>人参加><br>
                <input type="text"  name="course_name" disabled value=评分:<%=((CourseRemark)session.getAttribute("signal_course")).getGrade()%>分  ><br>
                <%
                    //-1表示学生未加入该课程
                    if (((CourseRemark)session.getAttribute("signal_course")).getBool_remark() == -1 ){
                %>
                <form action="../addCourseServlet" method="post">
                    <input type="submit" value="Join In" class="join"/>
                </form>
                <%
                    }
                %>
                <%
                    //为0来表示学生未评价该课程
                    if (((CourseRemark)session.getAttribute("signal_course")).getBool_remark() == 0){
                %>
                <form action="../remarkServlet" name="remarkForm" method="post" style="width: 100%;height: 30px">
                    <div id="remark">
                        <input type="radio" name="ident" value="1" checked>1.0
                        <input type="radio" name="ident" value="2" >2.0
                        <input type="radio" name="ident" value="3" >3.0
                        <input type="radio" name="ident" value="4" >4.0
                        <input type="radio" name="ident" value="5" >5.0
                    </div>
                    <input type="button" value="Score" onclick="remark()" id="btn" >
                </form>
                <%
                    }
                %>
                <%
                    //1来表示学生已评价该课程
                    if (((CourseRemark)session.getAttribute("signal_course")).getBool_remark()==1){
                %>
                <%
                    }
                %>
                <%
                    //不-1代表学生已加入课程
                    if (((CourseRemark)session.getAttribute("signal_course")).getBool_remark()!=-1){
                %>
                <form action="../studyServlet" name="studyForm" method="post">
                    <input type="hidden" name="course_id" value=<%=((CourseRemark)session.getAttribute("signal_course")).getCourse_id()%>>
                    <input type="hidden" name="chapter_id" value="1">
                    <input type="submit"  value="Start" class="start">
                </form>
                <form action="../exitCourseServlet" method="post">
                    <input type="submit" value="Quit" style="width: 80px;height: 40px;float: right" class="quit">
                </form>
                <br/>
                <%
                    }
                %>
                <button type="button" onClick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
            </div>
            <%
                }
            %>
        </div>
    </div>
</body>
<script  language="JavaScript" type="text/javascript">

    //获取模型
    var modal = document.getElementById('id01');
    //鼠标点击模型外区域关闭登录框
    window.onclick = function(event) {
        if (event.target == modal) {
            // 此元素不会被显示
            modal.style.display = "none";
        }
    };
    <%
        if ((int)session.getAttribute("bool_press") ==1){
    %>
        document.getElementById('id01').style.display='block';
     <%
        session.setAttribute("bool_press",0);
        }else if((int)session.getAttribute("bool_press") ==0){
     %>
        document.getElementById('id01').style.display='none';
     <%
        }
     %>
    function fly() {
        document.getElementsByName("temp").submit();
    }
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
    if(remark_result === 0){
        alert("更新失败");
    }else if(remark_result ===-1){
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
</html>
