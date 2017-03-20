<%--
  Created by IntelliJ IDEA.
  User: superfq
  Date: 2017/3/17
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <base href="http://localhost:8080/"/>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.2.0.js"></script>

</head>
<body>
<div id="mydiv">
    <form action="createUser.do" method="post">
    <input type="text" width="500px" name="sname" /><br/>
    <input type="password" width="500px" name="password">
    <input type="submit" width="50px" value="百度一下" id="i1"/>
    </form>
</div>
<div id="div" ></div>
</body>
<script type="text/javascript">
    var name;
    $("#i1").click(function(){
        $.ajax({
            type:"Post",
            url:"ajax.do",
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success:function(data){
                name = data.success;
            }
        });
        $("#div").html(name);
    });

</script>
</html>
