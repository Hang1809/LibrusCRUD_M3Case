package hangdinh.librusmanagement.dao;

import hangdinh.librusmanagement.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface IbookDAO {

    public void insertBook(Book book) throws SQLException;

    public Book selectBook(int id) throws SQLException;

    public List<Book> selectAllBooks();

    public boolean deleteBook(int id) throws SQLException;

    public boolean updateBook(Book book) throws SQLException;


}
