<%--
  Created by IntelliJ IDEA.
  User: 19626
  Date: 2023/1/17
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/object.action" method="get">
    <input type="submit" value="提交">
    <input name="name" value="Alan">
    <input name="pwd" value="你好">
</form>
</body>
</html>
