package model;

import entities.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class working with MySQL database
 */
public class DBHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(DBHelper.class);

    private static final String URL = "jdbc:mysql://localhost:3306/librarydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    /**
     * Method add book into database
     *
     * @param book simple java bean object
     * @return true if the book is added and false if not
     */
    public static synchronized boolean addBook(Book book) {
        LOGGER.info("Add book to database");

        String authorName = book.getAuthorName();
        String bookName = book.getBookName();
        String path = book.getFileName();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                 PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO books (book, author, filePath) VALUES (?, ?, ?)")) {

                if (bookName != null && authorName != null && path != null) {
                    preparedStatement.setString(1, bookName);
                    preparedStatement.setString(2, authorName);
                    preparedStatement.setString(3, path);

                    preparedStatement.executeUpdate();
                    return true;
                }

                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Exception while adding entity to database!");
        }

        return false;
    }

    /**
     * Method get book from database by name
     * @param bookName
     * @return book object
     */
    public static Book getBookByName(String bookName) {
        LOGGER.info("Get book from database");

        Book book = null;

        if (bookName == null || bookName.equals("")) return null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                 PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Books WHERE book = ?")) {

                preparedStatement.setString(1, bookName);

                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){

                    String author = resultSet.getString(3);
                    String path = resultSet.getString(4);

                    book = new Book(author, bookName, path);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Exception while get entity by bookName from database!");
        }

        return book;
    }

    /**
     * Method get list of book from database by name author
     * @param authorName
     * @return
     */
    public static List<Book> getAllBooksByAuthor(String authorName) {
        LOGGER.info("Get list of books from database");

        List<Book> books = new ArrayList<>();

        String author = "unknown_author";
        if (authorName != null && !authorName.equals("")) author = authorName;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                 Statement statement = connection.createStatement()) {

                ResultSet findAllBooks = statement.executeQuery("select book from Books where author = '" + author + "'");
                while (findAllBooks.next()) {
                    books.add(new Book(author, findAllBooks.getString("book")));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Exception while get all books by author name from database!");
        }

        return books;
    }
}
