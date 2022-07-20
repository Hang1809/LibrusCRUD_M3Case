package hangdinh.librusmanagement.dao;

import hangdinh.librusmanagement.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static hangdinh.librusmanagement.connection.Connection.getConnection;


public class BookDAO implements IbookDAO {

    private static final String INSERT_BOOKS_SQL =
            " INSERT INTO book (idBook, isbn,title,author,subject,languageId,publisherId,createdAt) \n" +
                    "VALUES (?,?,?,?,?,?,?,?);";

    private static final String SELECT_BOOK_BY_ID =
            "SELECT \n" +
                    "b.idBook, b.isbn, b.title, b.author, b.subject, b.languageId, b.publisherId\n" +
                    "FROM book as b \n" +
                    "WHERE idBook = ?;";
    private  static final String SELECT_ALL_BOOKS = "SELECT * FROM book";

    private static final String DELETE_BOOKS_SQL = "DELETE FROM book WHERE idBook =?";

    private static final String UPDATE_BOOKS_SQL =
            "UPDATE book \n" +
                    "SET isbn = ?, title = ?, author = ?, subject =?, languageId =?, publisherId =?, createdAt = ? \n" +
                    "WHERE idBook = ?;";



    @Override
    public void insertBook(Book book) throws SQLException {
        System.out.println(INSERT_BOOKS_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKS_SQL)) {
            preparedStatement.setInt(1, book.getId());
            preparedStatement.setString(2, book.getIsbn());
            preparedStatement.setString(3, book.getTitle());
            preparedStatement.setString(4, book.getAuthor());
            preparedStatement.setString(5, book.getSubject());
            preparedStatement.setInt(6, book.getLanguage());
            preparedStatement.setInt(7, book.getPublisher());
            preparedStatement.setDate(8, new java.sql.Date(book.getCreatedAt().getTime()));
            preparedStatement.executeUpdate();
            System.out.println(this.getClass() + " insertBook(): " + preparedStatement);

        } catch (SQLException ex) {
            printSQLException(ex);
        }

    }


    @Override
    public Book selectBook(int id) throws SQLException {
        Book book = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String isbn = rs.getString("isbn");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String subject = rs.getString("subject");
                int language = Integer.parseInt(rs.getString("languageId"));
                int publisher = Integer.parseInt(rs.getString("publisherId"));
                java.util.Date createdAt = new java.util.Date();
                book = new Book(id, isbn, title, author, subject, language, publisher, createdAt);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return book;
    }


    @Override
    public List<Book> selectAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("idBook");
                String isbn = rs.getString("isbn");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String subject = rs.getString("subject");
                int language = Integer.parseInt(rs.getString("languageId"));
                int publisher = Integer.parseInt(rs.getString("publisherId"));
                java.util.Date createdAt = new java.util.Date();
                books.add(new Book(id, isbn, title, author, subject, language, publisher, createdAt));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return books ;
    }


    @Override
    public boolean deleteBook(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOKS_SQL);){
            preparedStatement.setInt(1,id);
            rowDeleted = preparedStatement.executeUpdate() >0;

        }
        return rowDeleted;
    }

    @Override
    public boolean updateBook(Book book) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BOOKS_SQL)) {
            statement.setString(1, book.getIsbn());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthor());
            statement.setString(4,book.getSubject());
            statement.setInt(5,book.getLanguage());
            statement.setInt(6,book.getPublisher());
            java.util.Date createdAt = new java.util.Date();
            statement.setDate(7, (Date) book.getCreatedAt());
            statement.setInt(8,book.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;

    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
