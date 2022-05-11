<%@ page import="entities.Book" %><%--
  Created by IntelliJ IDEA.
  User: 79523
  Date: 08.05.2022
  Time: 3:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get Book</title>
    <link rel="stylesheet" href="../style/w3.css">
    <meta charset="UTF-8">
</head>
<body>
<div class="w3-card-4">
    <div class="w3-container w3-center w3-green">
        <h2>Поиск книги по названию</h2>
    </div>
    <form method="post" class="w3-selection w3-light-grey w3-padding">
        <label>Введите название книги:
            <input required type="text" name="bookName" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br/>
        </label>

        <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Поиск</button>
    </form>
</div>

<%
    if(request.getAttribute("haveBook") != null && request.getAttribute("haveNotDownloadPath") == null) {
        Book book = (Book) request.getAttribute("haveBook");

        out.println("<div class=\"w3-container w3-center w3-margin-bottom w3-padding\">" +
                "<div class=\"w3-card-4\">" +
                "<div class=\"w3-container w3-light-blue\">" +
                "<h2>Найденная книга написана автором: " + book.getAuthorName() + "</h2>" +
                "</div> ");

        out.println("<ul class=\"w3-ul\"> <li class=\"w3-hover-sand\"> Найденная книга: " + book.getBookName() + "</li>" +
                "<li class=\"w3-hover-sand\"> Скачать книгу в формате '.txt': <a href=\"/download\" download>ССЫЛКА</a> </li>");
        out.println("</ul></div></div>");

    } else if (request.getAttribute("haveNotBook") != null){
        out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n" +
                "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                "   <p> Такой книги у нас нету, поищите другую, либо проверте правильность ввода. </p>\n" +
                "</div>");
    } else if (request.getAttribute("haveNotDownloadPath") != null) {
        out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n" +
                "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                "   <p> К сожалению файл не найден, попробуйте позже. </p>\n" +
                "</div>");
    }
%>

<div class="w3-container w3-green w3-left-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/'">Назад в главное меню</button>
</div>
</body>
</html>
