<%--
  Created by IntelliJ IDEA.
  User: 14025
  Date: 2017/5/10
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    <div style="width:1320px;height: 40px;float: left ;margin-top: 20px">
        <div style="border:1px solid black;width: 300px;height: 40px;float: left;margin-left: 50px">
            <div style="height: 40px;width: 100px;text-align: center;line-height: 40px;border-right:1px solid black;float: left;font-family: STHupo  ;color: #728DBA ">开课时间:</div>
            <div style="float: left;height: 40px;width: 199px;">
                <select style="height: 40px;width: 199px;text-align:center " id="selectOne" >
                    <option selected="selected" value="" style="font-size: 20px; font-family: 'SimSun'">请选择</option>
                    <option value="2013-2014-1" style="">2013-2014-1</option>
                    <option value="2013-2014-2">2013-2014-2</option>
                    <option value="2014-2015-1">2014-2015-1</option>
                    <option value="2014-2015-2">2014-2015-2</option>
                    <option value="2015-2016-1">2015-2016-1</option>
                    <option value="2015-2016-2">2015-2016-2</option>
                    <option value="2016-2017-1">2016-2017-1</option>
                    <option value="2016-2017-2">2016-2017-2</option>
                </select>
            </div>
        </div>

        <div style="border:1px solid black;width: 300px;height: 40px;float: left;margin-left: 150px">
            <div style="height: 40px;width: 100px;text-align: center;line-height: 40px;border-right:1px solid black;float: left;font-family: STHupo  ;color: #728DBA ">课程名称:</div>
            <div style="float: left;height: 40px;width: 199px;">
                <input id="inputOne" type="text" style="width: 199px;height: 40px;font-family: Microsoft YaHei;font-size: 18px" placeholder="请输入课程名称"></div>
            </div>
        </div>

    <div style="width:1320px;height: 40px;float: left;margin-top: 50px">
        <div style="border:1px solid black;width: 300px;height: 40px;float: left;margin-left: 50px">
            <div style="height: 40px;width: 100px;text-align: center;line-height: 40px;border-right:1px solid black;float: left;font-family: STHupo  ;color: #728DBA">考查方式:</div>
            <div style="float: left;height: 40px;width: 199px;">
                <select style="height: 40px;width: 199px; " id="selectTwo">
                    <option selected="selected"value="">请选择</option>
                    <option value="考查">考查</option>
                    <option value="考试">考试</option>
                </select>
            </div>
        </div>

        <div style="border:1px solid black;width: 300px;height: 40px;float: left;margin-left: 150px">
            <div style="height: 40px;width: 100px;text-align: center;line-height: 40px;border-right:1px solid black;float: left;font-family: STHupo  ;color: #728DBA">课程性质:</div>
            <div style="float: left;height: 40px;width: 199px;">
                <select style="height: 40px;width: 199px; " id="selectThree">
                    <option selected="selected"value="">请选择</option>
                    <option value="必修">必修</option>
                    <option value="选修">选修</option>
                </select>
            </div>
        </div>

        <div style="margin-left: 800px;width: 100px;height: 50px;float: left;margin-left: 1000px;margin-top: 10px">
           <input  type="button" value="搜索" style="background: rgba(75,9,45,0.85);width: 150px;height: 50px;font-family: STHupo;font-size: 20px;color: beige;border-radius:15px" onclick="search();" >
        </div>
</div>
</div>
<div class="bottomDiv">

    <div class="Nsb_layout_r">
　
        <table width="100%" border="0" cellspacing="0" cellpadding="0" class="Nsb_r_list Nsb_table">
            <tbody>
            <tr>
                <th class="Nsb_r_list_thb" scope="col">课程编号</th>
                <th class="Nsb_r_list_thb" scope="col">课程名称</th>
                <th class="Nsb_r_list_thb" scope="col">学分</th>
                <th class="Nsb_r_list_thb" scope="col">课程类别</th>
                <th class="Nsb_r_list_thb" scope="col">课程性质</th>
                <th class="Nsb_r_list_thb" scope="col">总成绩</th>
                <th class="Nsb_r_list_thb" scope="col">上课时间</th>
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
                       <td>${commonCourses.curriculumNature}</td>
                       <td>${commonCourses.score}</td>
                       <td>${commonCourses.studyTime}</td>
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
                            <td>${professionalCourses.curriculumNature}</td>
                            <td>${professionalCourses.score}</td>
                            <td>${professionalCourses.studyTime}</td>
                        </tr>

                    </c:forEach>

                </c:otherwise>
            </c:choose>



            <tr>
                <td colspan="7" align="left" style="background-color:#E5F3FE">
                    <b>实践环节</b>
                </td>
            </tr>


            <c:choose >
                <c:when test="${empty courseListDto.laboratoryCourses}">
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
                    <c:forEach items="${courseListDto.laboratoryCourses}" var="laboratoryCourses">
                        <tr>
                            <td>${laboratoryCourses.id}</td>
                            <td>${laboratoryCourses.courseName}</td>
                            <td>${laboratoryCourses.credit}</td>
                            <td>${laboratoryCourses.courseCategory}</td>
                            <td>${laboratoryCourses.curriculumNature}</td>
                            <td>${laboratoryCourses.score}</td>
                            <td>${laboratoryCourses.studyTime}</td>
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
