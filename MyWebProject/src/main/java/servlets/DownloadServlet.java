package servlets;

import entities.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Servlet which download the book in format .txt
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddBookServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("Get method working");

        Book book = (Book) request.getSession().getAttribute("book");
        Path path = (Path) request.getSession().getAttribute("downloadPath");

        response.setContentType("text/plain");
        response.setHeader("Content-disposition", "attachment; filename=" + book.getBookName() + ".txt");

        LOGGER.warn("File download process");
        try (OutputStream out = response.getOutputStream();
             InputStream in = Files.newInputStream(path)) {
            byte[] buffer = new byte[4096];
            int length;

            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            out.flush();
        } catch (IOException e) {
            LOGGER.error("Exception while downloading a file");
        }

        request.getSession().removeAttribute("download");
    }
}
