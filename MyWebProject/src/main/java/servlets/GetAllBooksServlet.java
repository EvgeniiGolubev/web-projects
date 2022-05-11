package servlets;

import entities.Book;
import model.DBHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet which gets the all books by certain author from database and sends a display request to getAllBooks.jsp
 */
public class GetAllBooksServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddBookServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Post method working");

        request.setCharacterEncoding("UTF-8");

        String authorName = request.getParameter("author");

        List<Book> books = DBHelper.getAllBooksByAuthor(authorName);

        request.setAttribute("books", books);

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Get method working");

        request.setCharacterEncoding("UTF-8");

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/getAllBooks.jsp");
        dispatcher.forward(request, response);
    }
}
