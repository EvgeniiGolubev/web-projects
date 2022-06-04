<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 79523
  Date: 30.05.2022
  Time: 1:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <c:if test="${empty film.title}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty film.title}">
        <title>Edit</title>
    </c:if>
</head>
<body>

<c:if test="${empty film.title}">
    <c:url value="/add" var="var"/>
</c:if>

<c:if test="${!empty film.title}">
    <c:url value="/edit" var="var"/>
</c:if>

<form action="${var}" method="post">
    <c:if test="${!empty film.title}">
        <input type="hidden" name="id" value="${film.id}">
    </c:if>
    <lable for="title">Title</lable>
    <input type="text" name="title" id="title">
    <lable for="year">Year</lable>
    <input type="text" name="year" id="year">
    <lable for="genre">Genre</lable>
    <input type="text" name="genre" id="genre">
    <lable for="watched">Watched</lable>
    <input type="text" name="watched" id="watched">

    <c:if test="${empty film.title}">
        <input type="submit" value="Add new film">
    </c:if>

    <c:if test="${!empty film.title}">
        <input type="submit" value="Edit film">
    </c:if>
</form>

</body>
</html>
