<%@ page import="entities.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 79523
  Date: 08.05.2022
  Time: 4:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get all books</title>
    <link rel="stylesheet" href="../style/w3.css">
    <meta charset="UTF-8">
</head>
<body>
<div class="w3-card-4">
    <div class="w3-container w3-center w3-green">
        <h2>Список всех книг</h2>
    </div>
    <form method="post" class="w3-selection w3-light-grey w3-padding">
        <label>Введите имя автора:
            <input type="text" name="author" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br/>
        </label>

        <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Поиск</button>
    </form>
</div>

<%
    if (request.getAttribute("books") != null) {
        List<Book> books = (List<Book>) request.getAttribute("books");

        out.println("<div class=\"w3-container w3-center w3-margin-bottom w3-padding\">" +
                    "<div class=\"w3-card-4\">" +
                    "<div class=\"w3-container w3-light-blue\">" +
                "<h2>Книги автора</h2>" + "</div>");

        if (books != null && !books.isEmpty()) {

            out.println("<ul class=\"w3-ul\">");
            for (Book b : books) {
                out.println("<li class=\"w3-hover-sand\"> Автор: " + b.getAuthorName() + ". Название книги: " + b.getBookName() + "</li>");
            }
            out.println("</ul>");
        } else out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                +
                "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                "   <p>Книги данного автора ещё не добавлены</p>\n" +
                "</div>");
        out.println("</div></div>");
    }
%>


<div class="w3-container w3-green w3-left-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/'">Назад в главное меню</button>
</div>
</body>
</html>
