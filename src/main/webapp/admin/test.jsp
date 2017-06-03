<%--
  Created by IntelliJ IDEA.
  User: 14025
  Date: 2017/5/10
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix ="fmt" %>
<html>
<head>
    <title>查询课程</title>
    <base href="http://localhost:8080/"/>
    <link rel="stylesheet" type="text/css" href="../course.css">
    <link href="../css/common.css" rel="stylesheet" type="text/css">
    <link href="../css/blue.css" rel="stylesheet" type="text/css" id="link_theme">
    <link href="../css/workstation.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
        var content;
        var courseId;
        var temp;
        var select;
        function change(wasContent,id) {
            content =wasContent;
            var arr = id.split(",");
            courseId = arr[1];
            var  inputId = arr[0]+arr[1];
            select = arr[0];
            temp = 'ab'+arr[1];
            if (wasContent=='暂无数据'){
                var  val = "请输入数据";
                $('#'+inputId).html("");
                $('#'+inputId).append($("<input size='18px' autofocus>").attr("id",temp).append("type","text").attr("value",val).attr("onblur","score()"));


            }else {
                var  val =wasContent;
                $('#' + inputId).html("");
                $('#'+inputId).append($("<input size='18px' autofocus>").attr("id",temp).append("type","text").attr("value",val).attr("onblur","score()"));

            }
        }


        function score() {

            var score= $('#'+temp).val();
            $('#'+courseId).html(score);
            $('#'+temp).remove();
            if (content=='暂无数据'&&score!="请输入"){
                window.location.href="changeTest.do?score="+score+"&courseId="+courseId+"&select="+select;
            }else if(score=="请输入") {
                window.location.href="teacher/selectStudent.jsp";
            }else {
                window.location.href="changeTest.do?score="+score+"&courseId="+courseId+"&select="+select;
            }

        }
    </script>

    <style type="text/css">
        option{
            font-size: 20px;
            font-family: 'SimSun'
        }
    </style>


</head>
<body>
<div style=" border-bottom: 1px solid black ; width: 1320px;height: 250px;" >

<div class="bottomDiv">

    <div class="Nsb_layout_r">
　
        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="Nsb_r_list Nsb_table">
            <tbody>
            <tr>
                <th class="Nsb_r_list_thb" scope="col">课程编号</th>
                <th class="Nsb_r_list_thb" scope="col">课程名称</th>
                <th class="Nsb_r_list_thb" scope="col">学分</th>
                <th class="Nsb_r_list_thb" scope="col">课程类别</th>
                <th class="Nsb_r_list_thb" scope="col">考试时间</th>
                <th class="Nsb_r_list_thb" scope="col">考试教室</th>
                <th class="Nsb_r_list_thb" scope="col">监考老师</th>
            </tr>

            <tr>
                <td colspan="7" align="left" style="background-color:#E5F3FE">
                    <b>通识课</b>
                </td>
            </tr>
       <c:choose >
           <c:when test="${empty courseListDto.commonCourses}">
               <tr>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
                   <td>&nbsp;</td>
               </tr>
           </c:when>
           <c:otherwise >
               <c:forEach items="${courseListDto.commonCourses}" var="commonCourses">
                   <tr>
                       <td>${commonCourses.id}</td>
                       <td>${commonCourses.courseName}</td>
                       <td>${commonCourses.credit}</td>
                       <td>${commonCourses.courseCategory}</td>
                       <td id="tesTime${commonCourses.id}" onclick="change('${commonCourses.testTime}','tesTime,${commonCourses.id}')">${commonCourses.testTime}</td>
                       <td id="classRoom${commonCourses.id}" onclick="change('${commonCourses.classRoom}','classRoom,${commonCourses.id}')">${commonCourses.classRoom}</td>
                       <td id="teacherName${commonCourses.id}" onclick="change('${commonCourses.teacherName}','teacherName,${commonCourses.id}')">${commonCourses.teacherName}</td>
                   </tr>

               </c:forEach>

           </c:otherwise>
       </c:choose>



            <tr>
                <td colspan="7" align="left" style="background-color:#E5F3FE">
                    <b>专业基础</b>
                </td>
            </tr>

            <c:choose >
                <c:when test="${empty courseListDto.professionalCourses}">
                    <tr>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;</td>
                    </tr>
                </c:when>
                <c:otherwise >
                    <c:forEach items="${courseListDto.professionalCourses}" var="professionalCourses">
                        <tr>
                            <td>${professionalCourses.id}</td>
                            <td>${professionalCourses.courseName}</td>
                            <td>${professionalCourses.credit}</td>
                            <td>${professionalCourses.courseCategory}</td>
                            <td id="tesTime${professionalCourses.id}" onclick="change('${professionalCourses.testTime}','tesTime,${professionalCourses.id}')">${professionalCourses.testTime}</td>
                            <td id="classRoom${professionalCourses.id}" onclick="change('${professionalCourses.classRoom}','classRoom,${professionalCourses.id}')">${professionalCourses.classRoom}</td>
                            <td id="teacherName${professionalCourses.id}" onclick="change('${professionalCourses.teacherName}','teacherName,${professionalCourses.id}')">${professionalCourses.teacherName}</td>
                        </tr>

                    </c:forEach>

                </c:otherwise>
            </c:choose>




            </tbody>
        </table>
        <br>
    </div>
</div>



</body>
</html>
