<%@ page import="com.aurora.javaweb.bean.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 19626
  Date: 2022/11/11
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //拿到转发内容
    List<User> userList = (List<User>) request.getAttribute("userList");
    for (User user : userList) {
        out.write(user.toString());
    }
%>
</body>
</html>
