<%--
  Created by IntelliJ IDEA.
  User: 19626
  Date: 2022/12/16
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <base href="${pageContext.request.requestURL}">
</head>
<body>
<form action="transfer" method="post">
    from:<input type="text" name="from" /><br>
    to:<input type="text" name="to"><br>
    count:<input type="text" name="count" /><br>
    <input type="submit" value="转账"/><br>
</form>
</body>
</html>
