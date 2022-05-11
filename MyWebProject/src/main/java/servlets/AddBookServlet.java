package servlets;

import entities.Book;
import model.DBHelper;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.Iterator;
import java.util.List;

/**
 * Не разобрался с загрузкой файла на сервер
 *
 * Servlet which adds the book to the database and sends a display request to addBook.jsp
 */
public class AddBookServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddBookServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Post method working");

        request.setCharacterEncoding("UTF-8");

        String authorName = request.getParameter("author");
        String bookName = request.getParameter("book");
//        String fileName = request.getParameter("file");

        String fakeName = "Test.txt";
        Book book = new Book(authorName, bookName, fakeName);

        if (DBHelper.addBook(book)) {
            request.setAttribute("addedBook", true);
        } else {
            request.setAttribute("addedBook", false);
        }

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Get method working");

        request.setCharacterEncoding("UTF-8");

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/addBook.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Don't working :(
     * @param request
     */
    private void downloadFileFromUser(HttpServletRequest request) {
        String filePath = "C:\\Users\\79523\\JavaProjects\\Learning_web_Java\\MyWebProject\\src\\main\\resources\\books\\";
        File file = null;
        int memMaxSize = 100 * 1024;
        int fileMaxSize = 100 * 1024;

        LOGGER.debug("In method downloadFileFromUser");
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        diskFileItemFactory.setRepository(new File(filePath));
        diskFileItemFactory.setSizeThreshold(memMaxSize);

        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
        upload.setSizeMax(fileMaxSize);

        try {
            LOGGER.debug("In try block in method downloadFileFromUser");
            List fileItems = upload.parseRequest(request);
            Iterator iterator = fileItems.iterator();

            while (iterator.hasNext()) {
                FileItem fileItem = (FileItem) iterator.next();
                if (!fileItem.isFormField()) {

                    String fileName = fileItem.getName();
                    if (fileName.lastIndexOf("\\") >= 0) {
                        file = new File(filePath +
                                fileName.substring(fileName.lastIndexOf("\\")));
                    } else {
                        file = new File(filePath +
                                fileName.substring(fileName.lastIndexOf("\\") + 1));
                    }
                    LOGGER.debug("write file in method downloadFileFromUser");
                    fileItem.write(file);
                }
            }
        } catch (Exception e) {
            LOGGER.error("Exception in downloadFileFromUser method");
            e.printStackTrace();
        }

        System.out.println(file.getName());
    }
}
