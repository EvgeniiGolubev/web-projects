<%@ page import="entities.Book" %><%--
  Created by IntelliJ IDEA.
  User: 79523
  Date: 07.05.2022
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
    <link rel="stylesheet" href="../style/w3.css">
    <meta charset="UTF-8">
</head>
<body>
    <%
        if (request.getAttribute("addedBook") != null) {

            if ((Boolean) request.getAttribute("addedBook")) {
                out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                        "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                        "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                        "   <p> Книга: " + request.getParameter("book") + ". Автор: " + request.getParameter("author") +
                        "   . Успешно добавлена! </p>\n" +
                        "</div>");
            } else {
                out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n" +
                        "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                        "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                        "   <p> Книгу добавить не удалось! Попробуйте снова. </p>\n" +
                        "</div>");
            }
        }
    %>

    <div class="w3-card-4">
        <div class="w3-container w3-center w3-green">
            <h2>Добавить книгу</h2>
        </div>
        <form  method="post" class="w3-selection w3-light-grey w3-padding">
            <label>Введите имя автора:
                <input required value="unknown_author" type="text" name="author" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br/>
            </label>

            <label>Введите название книги:
                <input required type="text" name="book" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br/>
            </label>

            <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-top w3-margin-bottom">Добавить</button>
        </form>
    </div>

    <div class="w3-container w3-green w3-left-align w3-padding">
        <button class="w3-btn w3-round-large" onclick="location.href='/'">Назад в главное меню</button>
    </div>
</body>
</html>
