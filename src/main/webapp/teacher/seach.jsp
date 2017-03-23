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

    <title>Title</title>
    <base href="http://localhost:8080/"/>
    <script type="text/javascript" src="js/jquery-3.2.0.js"></script>

</head>
<body>
<div id="mydiv">

    <input type="text" width="500px" name="sname" /><br/>
    <input type="password" width="500px" name="password">
    <input type="button" width="50px" value="百度一下" id="i1"/>
</div>
<div id="div"></div>
<div id="d0"></div>
<div id="d1"></div>
<div id="d2"></div>
<div id="d3"></div>
</body>
<script type="text/javascript">
    $(function(){
        var count;

        $.ajax({
            type:"Post",
            url:"ajax.do",
            contentType:"application/json;charset=UTF-8",
            dataType:"json",
            success:function(data){
                count=data.length;
                var html='';
                var endDate;
                var i;
                $.each(data,function(index,value){
                    i="a"+index;
                html += "<div id="+i+">"+value+"</div>";
                    $("#div").html(html);
                });
            }
        });
        function seach(){
            var endDate;
           for (var i=0;i<count;i++){
              var index = "a"+i;
              endDate= $('#'+index+'').text();
              var time=new Date(endDate);
               countDate(time,i,div);
            }
        }

        setInterval(seach,1000);
        function countDate(endDate,index,div){

            var nowDate = new Date();
            var lastDate = endDate.getTime()-nowDate.getTime();
            var lastSecond = parseInt(lastDate/1000);
            var day = Math.floor(lastSecond/(24*60*60));
            var hour =Math.floor((lastSecond-(day*24*60*60))/3600);
            var minute=Math.floor((lastSecond-(day*24*60*60)-(hour*60*60))/60);
            var second = Math.floor(lastSecond-(day*24*60*60)-(hour*60*60)-(minute*60));
            var date = day+"天"+hour+"时"+minute+"分"+second+"秒";
            var div = "<div>"+date+"</div>";
           $('#d'+index+'').html(div);
        }

    });

</script>
</html>
