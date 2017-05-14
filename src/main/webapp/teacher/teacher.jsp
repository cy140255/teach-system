<%--
  Created by IntelliJ IDEA.
  User: 14025
  Date: 2017/4/17
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <title>教师终端</title>
    <base href="http://localhost:8080/"/>
    <link rel="stylesheet" type="text/css" href="css/courses.css">
</head>



<body>
<div style="position: relative;padding-left: 50px;">
    <div class="topDiv">
        <div class="top_left">
            <img src="img/系统.png" />
        </div>
        <div class="top_span">
            <span id="span">教务管理系统</span>
        </div>
    </div>

    <div class="leftDiv">
        <div class="left">
            <div class="left_img">
                <img src="img/课程.png" />
                <a href="select.do?id=${teacher.id}&temp=teacher" target="mainframe" style="text-decoration: none;color: #b52b27"> <span class="left_span">课程查询</span></a>
            </div>
        </div>
        <div class="left">
            <div class="left_img">
                <img src="img/成绩.png" />
                <a href="selectStudent.do?id=${teacher.id}" target="mainframe" style="text-decoration: none;color: #b52b27"> <span class="left_span">学生查询</span></a>
            </div>
        </div>
        <div class="left">
            <div class="left_img">
                <img src="img/选课.png" />
                <span class="left_span">选课管理</span>
            </div>
        </div>
        <div class="left">
            <div class="left_img">
                <img src="img/学籍.png" />
                <span class="left_span">个人信息管理</span>
            </div>
        </div>
    </div>
</div>
<div class="rightDiv" style="float: left">
    <iframe name="mainframe" src ="teacher/course.jsp" width="100%" height="1300px"></iframe>
</div>


</body>
</html>
