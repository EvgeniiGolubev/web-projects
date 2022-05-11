package entities;

import java.io.Serializable;

/**
 * Java simple bean
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    private String authorName;
    private String bookName;
    private String fileName;

    public Book() {}

    public Book(String authorName, String bookName) {
        this.authorName = authorName;
        this.bookName = bookName;
    }

    public Book(String authorName, String bookName, String fileName) {
        this.authorName = authorName;
        this.bookName = bookName;
        this.fileName = fileName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String author) {
        this.authorName = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String book) {
        this.bookName = book;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authorName='" + authorName + '\'' +
                ", bookName='" + bookName + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (getAuthorName() != null ? !getAuthorName().equals(book.getAuthorName()) : book.getAuthorName() != null)
            return false;
        if (getBookName() != null ? !getBookName().equals(book.getBookName()) : book.getBookName() != null)
            return false;
        return getFileName() != null ? getFileName().equals(book.getFileName()) : book.getFileName() == null;
    }

    @Override
    public int hashCode() {
        int result = getAuthorName() != null ? getAuthorName().hashCode() : 0;
        result = 31 * result + (getBookName() != null ? getBookName().hashCode() : 0);
        result = 31 * result + (getFileName() != null ? getFileName().hashCode() : 0);
        return result;
    }
}
