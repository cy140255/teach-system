<%--
  Created by IntelliJ IDEA.
  User: 14025
  Date: 2017/5/14
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员终端</title>
    <base href="http://localhost:8080/"/>
    <script type="text/javascript" src="js/jquery.js"></script>

    <script type="text/javascript">
        function save() {
            alert("保存成功")
            $("#form").submit();
        }
    </script>
</head>
<body>
<div style="text-align: center">
    <div>
        <form  id="form" action="addCourse.do" method="post">
            <div style="margin-bottom: 10px;margin-top: 20px;font-family: 'SimSun'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;课程名称：<input type="text" name="courseName"/><br></div>
            <div style="margin-bottom: 10px;font-family: 'SimSun'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学分&nbsp;：<input type="text" name="credit"/><br></div>
            <div style="margin-bottom: 10px;font-family: 'SimSun'">课程类别(必修/选修)&nbsp;：<input type="text" name="curriculumNature"/><br></div>
            <div style="margin-bottom: 10px;font-family: 'SimSun'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;课程性质：<input type="text" name="courseCategory"/><br></div>
            <div style="margin-bottom: 10px;font-family: 'SimSun'">&nbsp;&nbsp;&nbsp;上课时间(周期)：<input type="text" name="studyTime"/><br></div>
            <div style="margin-bottom: 10px;font-family: 'SimSun'">&nbsp;&nbsp;&nbsp;开课时间(学期)：<input type="text" name="courseStartDate"/><br></div>
            <div style="margin-bottom: 10px;font-family: 'SimSun'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上课教室：<input type="text" name="classroom"/><br></div>
            <div style="margin-bottom: 10px;font-family: 'SimSun'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上课老师：<input type="text" name="teacherName"/><br></div>
            <div style="margin-bottom: 10px;font-family: 'SimSun'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;总学时&nbsp;：<input type="text" name="period"/><br></div>
            <div style="margin-bottom: 10px;font-family: 'SimSun'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年级&nbsp;：<input type="text" name="grade"/><br></div>
            <div style="margin-bottom: 10px;font-family: 'SimSun'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;班级&nbsp;：<input type="text" name="clazz"/><br></div>
            <div><input type="button" onclick="save()" style="background: rgba(75,9,45,0.85);width: 90px;height: 30px;font-family: STHupo;font-size: 15px;color: beige;border-radius:15px"value="确定" name="courseName"/><br></div>
        </form>
    </div>
</div>
</body>
</html>
