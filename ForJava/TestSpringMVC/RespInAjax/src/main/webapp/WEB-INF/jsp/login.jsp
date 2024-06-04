<%--
  Created by IntelliJ IDEA.
  User: 19626
  Date: 2023/2/2
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login">
    用户名:<input name="name" type="text">
    密码:<input type="password" name="pwd">
    <input type="submit" value="登录">
</form>
</body>
</html>
