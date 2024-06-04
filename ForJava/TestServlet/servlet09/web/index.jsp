<%--
  Created by IntelliJ IDEA.
  User: 19626
  Date: 2022/11/15
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="<%=request.getContextPath()%>/test/a">123</a>
  <form action="<%=request.getContextPath()%>/login" method="post" >
    用户名<input type="text" name="username">
    密码<input type="password" name="passwd">
    <input type="submit" value="提交" onclick="">
  </form>
  </body>
</html>
