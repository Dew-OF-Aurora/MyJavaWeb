<%--
  Created by IntelliJ IDEA.
  User: 19626
  Date: 2022/11/15
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
你好, 欢迎
<%=request.getSession(false).getAttribute("user").toString()%>
<a href="<%=request.getContextPath()%>/exit">安全退出</a>
</body>
</html>
