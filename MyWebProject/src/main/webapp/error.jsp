<%--
  Created by IntelliJ IDEA.
  User: 79523
  Date: 09.05.2022
  Time: 2:26
  To change this template use File | Settings | File Templates.
--%>
<%
    String message = pageContext.getException().getMessage();
    String exception = pageContext.getException().getClass().toString();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exception</title>
</head>
<body>
<h2>Сорян, произошла ошибка :(</h2>
<p>А именно:</p>
<p>Тип: <%= exception%></p>
<p>Сообщение: <%= message %></p>
</body>
</html>
