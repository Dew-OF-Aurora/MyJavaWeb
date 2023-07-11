<%--
  Created by IntelliJ IDEA.
  User: 19626
  Date: 2023/2/1
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="js/jquery-3.6.1.js"></script>
    <title>Title</title>
</head>
<body>
<a href="javascript:myshow()">点击展示数据</a>
<div id="mydiv"></div>
<form action="${pageContext.request.contextPath}/mydate">
    时间:<input type="date" name="mydate">
    <input type="submit">
</form>
<a href="${pageContext.request.contextPath}/showlogin">登录</a>
</body>
</html>
<script>
    myshow=()=>{
        $.ajax({
            type:"GET",
            url:"${pageContext.request.contextPath}/show",
            dataType:"json",
            success:function (object) {
                var s = ""
                $.each(object,function (i,obj) {
                    s += obj.name+":"+obj.pwd+"<br>";
                })
                $("#mydiv").html(s);
            }
        })
    }
</script>