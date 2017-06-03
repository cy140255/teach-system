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
    <script type="text/javascript">
        function search() {
           var courseStartDate= document.getElementById("selectOne").value;
           var courseName= document.getElementById("inputOne").value;
           var assessment_Methods= document.getElementById("selectTwo").value;
           var curriculumNature= document.getElementById("selectThree").value;
           window.location.href="select.do?courseStartDate= "+courseStartDate+'&courseName='+courseName+'&assessment_Methods='+assessment_Methods+'&curriculumNature='+curriculumNature+'&id='+${student.id};

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
                <th class="Nsb_r_list_thb" scope="col">指导老师</th>
                <th class="Nsb_r_list_thb" scope="col">状态</th>
                <th class="Nsb_r_list_thb" scope="col">备注</th>
            </tr>

            <tr>
                <td colspan="7" align="left" style="background-color:#E5F3FE">
                    <b>毕业设计</b>
                </td>
            </tr>
       <c:choose >
           <c:when test="${empty courseListDto.graduationCourse}">
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
               <c:forEach items="${courseListDto.graduationCourse}" var="graduationCourse">
                   <tr>
                       <td>${graduationCourse.id}</td>
                       <td>${graduationCourse.courseName}</td>
                       <td>${graduationCourse.credit}</td>
                       <td>${graduationCourse.courseCategory}</td>
                       <td>${graduationCourse.teacherName}</td>
                       <td>${graduationCourse.statue}</td>
                       <td>&nbsp;</td>
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
