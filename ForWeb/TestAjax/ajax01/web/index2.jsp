<%--
  Created by IntelliJ IDEA.
  User: 19626
  Date: 2022/11/29
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="div"></div><br>
<input id="input" type="text" value="hello"/>
<hr>
用户名<input id="name" type="text"/>
密码<input id="pwd" type="text">
<input type="button" id="btn" value="提交">
<div id="div1"></div>
</body>
</html>
<script src="MyJquery-1.0.0.js"></script>
<script>
    <%--var xmlreq = new XMLHttpRequest()--%>
    <%--xmlreq.onreadystatechange = function (){--%>
    <%--    if (xmlreq.readyState === 4) {--%>
    <%--        if (this.status === 200){--%>
    <%--            var text = $("#input").val("你好")--%>
    <%--            $("#div").html(text)--%>
    <%--        }--%>
    <%--    }--%>
    <%--}--%>
    <%--xmlreq.open("GET","${pageContext.request.contextPath}/ajax/request",true)--%>
    <%--xmlreq.send()--%>
    $("#btn").click(function () {
        $.ajax({
            type:"GET",
            url:"${pageContext.request.contextPath}/ajax/request",
            async:true,
            data:{
                "name":$("#name").val(),
                "pwd":$("#pwd").val()
            },
            success:function(repjson) {
                //如果拿到的是一个JSON对象数组需要对该数组进行遍历
                $("#div1").html(repjson[0].name)
            }
        })
    })

</script>
