<%--
  Created by IntelliJ IDEA.
  User: 19626
  Date: 2022/11/21
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
  </head>
  <body>
  <form action="bank/submit" method="post">
    转到账号:<input type="text" name="toname"><br>
    持有账户:<input type="text" name="fromname"><br>
    转账金额:<input type="text" name="money"><br>
    <input type="submit">
  </form>
  </body>
</html>
