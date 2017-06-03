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
    <title>查询学生</title>
    <base href="http://localhost:8080/"/>
    <link rel="stylesheet" type="text/css" href="../course.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <link href="../css/common.css" rel="stylesheet" type="text/css">
    <link href="../css/blue.css" rel="stylesheet" type="text/css" id="link_theme">
    <link href="../css/workstation.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">
        function search() {
           var grade= document.getElementById("selectOne").value;
           var studentName= document.getElementById("inputOne").value;
           var major= document.getElementById("selectTwo").value;
           var departmentName= document.getElementById("selectThree").value;
           window.location.href="selectStudent.do?grade= "+grade+'&courseName='+studentName+'&studentName='+studentName+'&major='+major+'&departmentName='+departmentName+'&id='+${teacher.id};

        }
       var temp;
        var studentId;//学生id
        var courseId;//课程id
        var scoreNum;
         function change(score,id,Id) {
              scoreNum =score;
             var arr = id.split(",");
             studentId = arr[1];
            var  inputId = arr[0]+arr[1];
             courseId=Id;
            temp = 'ab'+arr[1];
            if (score=='暂无成绩'){
              var  val = "请输入成绩";
                $('#'+inputId).html("");
                $('#'+inputId).append($("<input size='10px' >").attr("id",temp).append("type","text").attr("value",val).attr("onblur","score()").attr("onkeypress","return event.keyCode>=48&&event.keyCode<=57||(this.value.indexOf('.')<0?event.keyCode==46:false)").attr("onpaste","return !clipboardData.getData('text').match(/\D/)"));


            }else {
                var  val =score;
                $('#' + inputId).html("");
                $('#'+inputId).append($("<input size='2px' >").attr("id",temp).append("type","text").attr("value",val).attr("onblur","score()").attr("onkeypress","return event.keyCode>=48&&event.keyCode<=57||(this.value.indexOf('.')<0?event.keyCode==46:false)").attr("onpaste","return !clipboardData.getData('text').match(/\D/)"));

            }


        }
       function score() {
             var teacherId = "${teacher.id}";
           var score= $('#'+temp).val();
           $('#'+studentId).html(score);
           $('#'+temp).remove();
            if (scoreNum=='暂无成绩'&&score!="请输入成绩"){
                window.location.href="inset.do?score="+score+'&studentId='+studentId+"&courseId="+courseId+'&teacherId='+teacherId;
            }else if(score=="请输入成绩") {
                window.location.href="teacher/selectStudent.jsp";
            }else {
                window.location.href="changeScore.do?score="+score+'&studentId='+studentId+"&courseId="+courseId+'&teacherId='+teacherId;
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
    <div style="width:1320px;height: 40px;float: left ;margin-top: 20px">
        <div style="border:1px solid black;width: 300px;height: 40px;float: left;margin-left: 50px">
            <div style="height: 40px;width: 100px;text-align: center;line-height: 40px;border-right:1px solid black;float: left;font-family: STHupo  ;color: #728DBA ">年级:</div>
            <div style="float: left;height: 40px;width: 199px;">
                <select style="height: 40px;width: 199px;text-align:center " id="selectOne" >
                    <option selected="selected" value="" style="font-size: 20px; font-family: 'SimSun'">请选择</option>
                    <option value="13级" style="">13级</option>
                    <option value="14级">14级</option>
                    <option value="15级">15级</option>
                    <option value="16级">16级</option>
                    <option value="17级">17级</option>

                </select>
            </div>
        </div>

        <div style="border:1px solid black;width: 300px;height: 40px;float: left;margin-left: 150px">
            <div style="height: 40px;width: 100px;text-align: center;line-height: 40px;border-right:1px solid black;float: left;font-family: STHupo  ;color: #728DBA ">学生姓名:</div>
            <div style="float: left;height: 40px;width: 199px;">
                <input id="inputOne" type="text" style="width: 199px;height: 40px;font-family: Microsoft YaHei;font-size: 18px" placeholder="请输入学生姓名"></div>
            </div>
        </div>

    <div style="width:1320px;height: 40px;float: left;margin-top: 50px">
        <div style="border:1px solid black;width: 300px;height: 40px;float: left;margin-left: 50px">
            <div style="height: 40px;width: 100px;text-align: center;line-height: 40px;border-right:1px solid black;float: left;font-family: STHupo  ;color: #728DBA">所在专业:</div>
            <div style="float: left;height: 40px;width: 199px;">
                <select style="height: 40px;width: 199px; " id="selectTwo">
                    <option selected="selected"value="">请选择</option>
                    <option value="考查">考查</option>
                    <option value="考试">考试</option>
                </select>
            </div>
        </div>

        <div style="border:1px solid black;width: 300px;height: 40px;float: left;margin-left: 150px">
            <div style="height: 40px;width: 100px;text-align: center;line-height: 40px;border-right:1px solid black;float: left;font-family: STHupo  ;color: #728DBA">所在院系:</div>
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
                <th class="Nsb_r_list_thb" scope="col">学生姓名</th>
                <th class="Nsb_r_list_thb" scope="col">所在专业</th>
                <th class="Nsb_r_list_thb" scope="col">班级</th>
                <th class="Nsb_r_list_thb" scope="col">课程名称</th>
                <th class="Nsb_r_list_thb" scope="col">学分</th>
                <th class="Nsb_r_list_thb" scope="col" >总成绩</th>
                <th class="Nsb_r_list_thb" scope="col">备注</th>
            </tr>

            <tr>
                <td colspan="7" align="left" style="background-color:#E5F3FE">
                    <b>通识课</b>
                </td>
            </tr>
       <c:choose >
           <c:when test="${empty selectStudent.commonCourses}">
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

               <c:forEach items="${selectStudent.commonCourses[0].studentDtoList}" var="commonCourses">
                   <tr>
                       <td><a href="findStudent.do?studentId=${commonCourses.id}" >${commonCourses.studentName}</a></td>
                       <td>${commonCourses.majorName}</td>
                       <td>${commonCourses.clazz}</td>
                       <td>${selectStudent.commonCourses[0].courseName}</td>
                       <td>${selectStudent.commonCourses[0].credit}</td>
                       <td id="a${commonCourses.id}"  style="word-break:break-all;word-wrap:break-word;"  onclick="change('${commonCourses.score}','a,${commonCourses.id}','${selectStudent.commonCourses[0].id}')">${commonCourses.score}</td>
                       <td>&nbsp;</td>
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
                <c:when test="${empty selectStudent.professionalCourses}">
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
                    <c:forEach items="${selectStudent.professionalCourses[0].studentDtoList}" var="professionalCourses">
                        <tr>
                            <td><a href="findStudent.do?studentId=${professionalCourses.id}" >${professionalCourses.studentName}</a></td>
                            <td>${professionalCourses.majorName}</td>
                            <td>${professionalCourses.clazz}</td>
                            <td>${selectStudent.professionalCourses[0].courseName}</td>
                            <td>${selectStudent.professionalCourses[0].credit}</td>
                            <td id="b${professionalCourses.id}" onclick="change('${professionalCourses.score}','b,${professionalCourses.id}','${selectStudent.professionalCourses[0].id}')">${professionalCourses.score}</td>
                            <td>&nbsp;</td>
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
                <c:when test="${empty selectStudent.laboratoryCourses}">
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
                    <c:forEach items="${selectStudent.laboratoryCourses[0].studentDtoList}" var="laboratoryCourses">
                        <tr>
                            <td><a href="findStudent.do?studentId=${laboratoryCourses.id}" >${laboratoryCourses.studentName}</a></td>
                            <td>${laboratoryCourses.majorName}</td>
                            <td>${laboratoryCourses.clazz}</td>
                            <td>${selectStudent.laboratoryCourses[0].courseName}</td>
                            <td>${selectStudent.laboratoryCourses[0].credit}</td>
                            <td>${laboratoryCourses.score}</td>
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
