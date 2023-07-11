<%@ page import="java.util.Date" %>
<%@ page import="jakarta.servlet.http.HttpSession" %><%--
  Created by IntelliJ IDEA.
  User: 19626
  Date: 2022/11/17
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
  Date date = new Date();
  Date date2 = new Date();
  request.setAttribute("time",date);
  HttpSession session1 = request.getSession();
  session1.setAttribute("time",date2);
  session1.setAttribute("qwe","123");
%>
${time}
<br>
${sessionScope.time}
<br>
${sessionScope.time}
<br>
<%=request.getServletContext()%>
${pageContext.request.contextPath}
<br>
${pageContext.servletContext}
<br>
${paramValues.username}
${paramValues.pwd[0]}
${paramValues.pwd[1]}