
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- saved from url=(0037)http://211.70.160.131/jsxsd/grxx/xsxx -->
<html>
	<!--<base target="_self">--><base href="." target="_self">
	<title>学籍卡片</title>	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8">
	<base href="http://localhost:8080/"/>
<script type="text/javascript" src="../js/jquery-min.js.下载" language="javascript"></script>
<script type="text/javascript" src="../js/common.js.下载" language="javascript"></script>
<script type="text/javascript" src="../js/iepngfix_tilebg.js.下载" language="javascript"></script>
<link href="../css/common.css" rel="stylesheet" type="text/css">
<link href="../css/blue.css" rel="stylesheet" type="text/css" id="link_theme">
<link href="../css/workstation.css" rel="stylesheet" type="text/css">
</head>
<body>
<script type="text/javascript">
jQuery(document).ready(function(){
	window.setInterval(function(){
		 document.getElementById("notSession").src = "/jsxsd/framework/blankPage.jsp";
	 }, 1000 * 60 * 10);
});
</script>



</div>

	<table id="xjkpTable" width="1000" border="0" style="border-collapse:collapse; table-layout:fixed" align="center">
		<tbody><tr style="border:0px solid black">
			<td align="center" style="border:0px solid black" width="76px"></td>
			<td align="center" style="border:0px solid black" width="70px"></td>
			<td align="center" style="border:0px solid black" width="60px"></td>
			<td align="center" style="border:0px solid black" width="92px"></td>
			<td align="center" style="border:0px solid black" width="140px"></td>
			<td align="center" style="border:0px solid black" width="140px"></td>
			<td align="center" style="border:0px solid black" width="86px"></td>
			<td align="center" style="border:0px solid black" width="50px"></td>
		</tr>
		
		<tr style="border:0px solid black">
			<td align="center" colspan="8" style="border:0px solid black;font-weight:bold; font-size:16px;">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;籍&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;卡&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片</td>
		</tr>
		<tr style="border:0px solid black">
			<td align="center" style="border:0px solid black" colspan="2">院系：${student.departmentName}</td>
			<td align="center" style="border:0px solid black" colspan="2">专业：${student.majorName}</td>
			<td align="center" style="border:0px solid black">学制：4</td>
			<td align="center" style="border:0px solid black">班级：${student.studentBaseInfo.clazz}</td>
			<td align="center" style="border:0px solid black" colspan="2">学号：${student.studentId}</td>
		</tr>
		<tr style="border:1px solid black">
			<td align="center" style="border:1px solid black">姓名</td>
			<td align="center" style="border:1px solid black">&nbsp;${student.studentBaseInfo.sname}</td>
			<td align="center" style="border:1px solid black">性别</td>
			<td align="center" style="border:1px solid black">&nbsp;${student.studentBaseInfo.gender}</td>
			<td align="center" style="border:1px solid black">姓名拼音</td>
			<td align="center" style="border:1px solid black">&nbsp;${student.studentBaseInfo.snameCN}</td>
			<td align="center" style="border:1px solid black" colspan="2" rowspan="5">
				<img alt="照片" src="./学籍卡片_files/xszpLoad" style="width:78px; height:110px;">
			</td>
		</tr>
		<tr style="border:1px solid black">
			<td align="center" style="border:1px solid black">出生日期</td>
			<td align="center" style="border:1px solid black">&nbsp;${student.studentBaseInfo.birthday}</td>
			<td align="center" style="border:1px solid black">婚否</td>
			<td align="center" style="border:1px solid black">&nbsp;${student.studentBaseInfo.isMarry}</td>
			<td align="center" style="border:1px solid black">本人电话</td>
			<td align="center" style="border:1px solid black">&nbsp;${student.studentBaseInfo.telPhone}</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">专业方向</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
			<td align="center" style="border:1px solid black">政治面貌</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentBaseInfo.politicalOutlook}</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">籍贯</td>
			<td align="center" style="border:1px solid black" colspan="5">&nbsp;${student.studentBaseInfo.nativePlace}</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">入党团时间</td>
			<td align="center" style="border:1px solid black" colspan="3">&nbsp;${student.studentBaseInfo.communistDate}</td>
			<td align="center" style="border:1px solid black">民族</td>
			<td align="center" style="border:1px solid black">&nbsp;${student.studentBaseInfo.national}</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">学习形式</td>
			<td align="center" style="border:1px solid black">&nbsp;</td>
			<td align="center" style="border:1px solid black">学习层次</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;普通本科</td>
			<td align="center" style="border:1px solid black">外语种类</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;英语</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">家庭现住址</td>
			<td align="center" style="border:1px solid black" colspan="4">&nbsp;${student.studentBaseInfo.homeAddress}</td>
			<td align="center" style="border:1px solid black">下车火车站</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">邮政编码</td>
			<td align="center" style="border:1px solid black">&nbsp;${student.studentBaseInfo.postcode}</td>
			<td align="center" style="border:1px solid black">家庭电话</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentBaseInfo.homeTelPhone}</td>
			<td align="center" style="border:1px solid black">联系人</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black" colspan="8">学&nbsp;&nbsp;&nbsp;习&nbsp;&nbsp;&nbsp;及&nbsp;&nbsp;&nbsp;工&nbsp;&nbsp;&nbsp;作&nbsp;&nbsp;&nbsp;简&nbsp;&nbsp;&nbsp;历</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black" colspan="2">起止年月</td>
			<td align="center" style="border:1px solid black" colspan="4">学&nbsp;&nbsp;&nbsp;校&nbsp;&nbsp;&nbsp;或&nbsp;&nbsp;&nbsp;工&nbsp;&nbsp;&nbsp;作&nbsp;&nbsp;&nbsp;单&nbsp;&nbsp;&nbsp;位</td>
			<td align="center" style="border:1px solid black" colspan="2">职务</td>
		</tr>
		<tr style="color: #00bbee">
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentExperiences[0].startAndEndDate}</td>
			<td align="center" style="border:1px solid black" colspan="4">&nbsp;${student.studentExperiences[0].workAddress}</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentExperiences[0].jobType}</td>
		</tr>
		<tr style="color: #00bbee">
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentExperiences[1].startAndEndDate}</td>
			<td align="center" style="border:1px solid black" colspan="4">&nbsp;${student.studentExperiences[1].workAddress}</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentExperiences[1].jobType}</td>
		</tr>
		<tr style="color: #00bbee">
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentExperiences[2].startAndEndDate}</td>
			<td align="center" style="border:1px solid black" colspan="4">&nbsp;${student.studentExperiences[2].workAddress}</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentExperiences[2].jobType}</td>
		</tr>
		<tr style="color: #00bbee">
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentExperiences[3].startAndEndDate}</td>
			<td align="center" style="border:1px solid black" colspan="4">&nbsp;${student.studentExperiences[3].workAddress}</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentExperiences[3].jobType}</td>
		</tr>
		<tr style="color: #00bbee">
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentExperiences[4].startAndEndDate}</td>
			<td align="center" style="border:1px solid black" colspan="4">&nbsp;${student.studentExperiences[4].workAddress}</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentExperiences[4].jobType}</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black" colspan="8">家&nbsp;&nbsp;&nbsp;庭&nbsp;&nbsp;&nbsp;成&nbsp;&nbsp;&nbsp;员&nbsp;&nbsp;&nbsp;情&nbsp;&nbsp;&nbsp;况</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">姓名</td>
			<td align="center" style="border:1px solid black" colspan="2">与本人关系</td>
			<td align="center" style="border:1px solid black" colspan="3">工作单位</td>
			<td align="center" style="border:1px solid black" colspan="2">职务</td>
		</tr>
		<tr style="color: #00bbee">
			<td align="center" style="border:1px solid black">&nbsp;${student.studentFamilyInfos[0].familyName}</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentFamilyInfos[0].relationship}</td>
			<td align="center" style="border:1px solid black" colspan="3">&nbsp;${student.studentFamilyInfos[0].workAddress}</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentFamilyInfos[0].jobType}</td>
		</tr>
		<tr style="color: #00bbee">
			<td align="center" style="border:1px solid black">&nbsp;${student.studentFamilyInfos[1].familyName}</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentFamilyInfos[1].relationship}</td>
			<td align="center" style="border:1px solid black" colspan="3">&nbsp;${student.studentFamilyInfos[1].workAddress}</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentFamilyInfos[1].jobType}</td>
		</tr>
		<tr style="color: #00bbee">
			<td align="center" style="border:1px solid black">&nbsp;${student.studentFamilyInfos[2].familyName}</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentFamilyInfos[2].relationship}</td>
			<td align="center" style="border:1px solid black" colspan="3">&nbsp;${student.studentFamilyInfos[2].workAddress}</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentFamilyInfos[2].jobType}</td>
		</tr>
		<tr style="color: #00bbee">
			<td align="center" style="border:1px solid black">&nbsp;${student.studentFamilyInfos[3].familyName}</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentFamilyInfos[3].relationship}</td>
			<td align="center" style="border:1px solid black" colspan="3">&nbsp;${student.studentFamilyInfos[3].workAddress}</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentFamilyInfos[3].jobType}</td>
		</tr>
		<tr style="color: #00bbee">
			<td align="center" style="border:1px solid black">&nbsp;${student.studentFamilyInfos[4].familyName}</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentFamilyInfos[4].relationship}</td>
			<td align="center" style="border:1px solid black" colspan="3">&nbsp;${student.studentFamilyInfos[4].workAddress}</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentFamilyInfos[4].jobType}</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black" colspan="8">学&nbsp;&nbsp;&nbsp;籍&nbsp;&nbsp;&nbsp;变&nbsp;&nbsp;&nbsp;动&nbsp;&nbsp;&nbsp;情&nbsp;&nbsp;&nbsp;况</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">异动类别</td>
			<td align="center" style="border:1px solid black" colspan="2">异动原因</td>
			<td align="center" style="border:1px solid black">异动日期</td>
			<td align="center" style="border:1px solid black" colspan="2">原院系</td>
			<td align="center" style="border:1px solid black">原专业</td>
			<td align="center" style="border:1px solid black">原年级</td>
		</tr>
		<tr style="color: #00bbee">
			<td align="center" style="border:1px solid black">&nbsp;${student.studentMajorChanges[0].transactionType}</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentMajorChanges[0].transactionReason}</td>
			<td align="center" style="border:1px solid black">&nbsp;${student.studentMajorChanges[0].transactionDate}</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.studentMajorChanges[0].originalDepartment}</td>
			<td align="center" style="border:1px solid black">&nbsp;${student.studentMajorChanges[0].originalMajor}</td>
			<td align="center" style="border:1px solid black">&nbsp;${student.studentMajorChanges[0].originalClass}</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
			<td align="center" style="border:1px solid black">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
			<td align="center" style="border:1px solid black">&nbsp;</td>
			<td align="center" style="border:1px solid black">&nbsp;</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
			<td align="center" style="border:1px solid black">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
			<td align="center" style="border:1px solid black">&nbsp;</td>
			<td align="center" style="border:1px solid black">&nbsp;</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
			<td align="center" style="border:1px solid black">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
			<td align="center" style="border:1px solid black">&nbsp;</td>
			<td align="center" style="border:1px solid black">&nbsp;</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
			<td align="center" style="border:1px solid black">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
			<td align="center" style="border:1px solid black">&nbsp;</td>
			<td align="center" style="border:1px solid black">&nbsp;</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black" colspan="8">奖&nbsp;&nbsp;&nbsp;励&nbsp;&nbsp;&nbsp;情&nbsp;&nbsp;&nbsp;况</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">奖励年度</td>
			<td align="center" style="border:1px solid black" colspan="2">奖励名称</td>
			<td align="center" style="border:1px solid black" colspan="3">颁奖单位</td>
			<td align="center" style="border:1px solid black" colspan="2">奖励等级</td>
		</tr>
		<tr style="color: #00bbee">
			<td align="center" style="border:1px solid black">&nbsp;${student.rewardSituations[0].rewardDate}</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.rewardSituations[0].rewardName}</td>
			<td align="center" style="border:1px solid black" colspan="3">&nbsp;${student.rewardSituations[0].rewardsCompany}</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.rewardSituations[0].rewoadLevel}</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="3">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="3">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="3">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="3">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black" colspan="8">处&nbsp;&nbsp;&nbsp;分&nbsp;&nbsp;&nbsp;情&nbsp;&nbsp;&nbsp;况</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">处分日期</td>
			<td align="center" style="border:1px solid black" colspan="2">处分名称</td>
			<td align="center" style="border:1px solid black" colspan="3">处分单位</td>
			<td align="center" style="border:1px solid black" colspan="2">处分原因</td>
		</tr>
		<tr style="color: #00bbee">
			<td align="center" style="border:1px solid black">&nbsp;${student.dispositionSituations[0].dispositionDate}</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.dispositionSituations[0].dispositionName}</td>
			<td align="center" style="border:1px solid black" colspan="3">&nbsp;${student.dispositionSituations[0].dispositionCompany}</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;${student.dispositionSituations[0].dispositionReason}</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="3">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="3">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="3">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="3">&nbsp;</td>
			<td align="center" style="border:1px solid black" colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">入学日期</td>
			<td align="center" style="border:1px solid black" colspan="3">&nbsp;${student.otherInfo.startDate}</td>
			<td align="center" style="border:1px solid black">毕业日期</td>
			<td align="center" style="border:1px solid black" colspan="3">&nbsp;${student.otherInfo.graduationDate}</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">入学考号</td>
			<td align="center" style="border:1px solid black" colspan="3">&nbsp;${student.otherInfo.testNum}</td>
			<td align="center" style="border:1px solid black">身份证编号</td>
			<td align="center" style="border:1px solid black" colspan="3">&nbsp;${student.otherInfo.pINCodes}</td>
		</tr>
		<tr>
			<td align="center" style="border:1px solid black">毕(结)业证书号</td>
			<td align="center" style="border:1px solid black" colspan="3">&nbsp;${student.otherInfo.graduation_certificate_num}</td>
			<td align="center" style="border:1px solid black">学士证书号</td>
			<td align="center" style="border:1px solid black" colspan="3">&nbsp;${student.otherInfo.baccalaureate_NUM}</td>
		</tr>
		
		<tr>
		    <td colspan="4" align="center" height="20"></td>
		</tr>
		<tr>
		    <td colspan="7" align="center"><input type="button" value="打 印" onclick="print(this)" class="button"></td>
		</tr>
	</tbody></table>
	

</div>
<br>
<iframe style="display:none;" name="ifrmPrint" id="ifrmPrint" src="./学籍卡片_files/saved_resource(1).html"></iframe>
<form action="http://211.70.160.131/jsxsd/grxx/xsxx" name="FormPrint" id="FormPrint" method="post" target="ifrmPrint"></form>





</body></html>