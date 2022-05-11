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
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Servlet which gets book by certain name from database and sends a display request to getBook.jsp
 * And send to DownloadServlet information about the file to be downloaded
 */
public class GetBookServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddBookServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Post method working");

        request.setCharacterEncoding("UTF-8");

        String bookName = request.getParameter("bookName");

        Book book = DBHelper.getBookByName(bookName);
        if (book != null) {
            request.setAttribute("haveBook", book);

            LOGGER.info("Trying to send an object to DownloadServlet");

            Path link = getDownloadLink(book.getFileName());
            if (link != null) {
                request.getSession().setAttribute("downloadPath", link);
                request.getSession().setAttribute("book", book);
            } else {
                request.setAttribute("haveNotDownloadPath", false);
            }

        } else {
            request.setAttribute("haveNotBook", false);
        }

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Get method working");

        request.setCharacterEncoding("UTF-8");

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/getBook.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Method makes a convenient download link
     *
     * @param fileName book name
     * @return the path where the book is kept
     */
    private Path getDownloadLink(String fileName) {
        LOGGER.info("Determining link availability");

        Path path = Path.of("C:\\Users\\79523\\JavaProjects\\Learning_web_Java\\MyWebProject\\src\\main\\resources\\books\\" + fileName);
        if (Files.exists(path)) return path;
        return null;
    }
}
