package hangdinh.librusmanagement.controller;

import hangdinh.librusmanagement.dao.BookDAO;
import hangdinh.librusmanagement.dao.IbookDAO;
import hangdinh.librusmanagement.model.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Date;

@WebServlet(name = "TestServlet", urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    IbookDAO ibookDAO;
    @Override
    public void init() throws ServletException {
        ibookDAO = new BookDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDAO bookDAO = new BookDAO();
//        (int id, String isbn, String title, String author,
//                String subject, int language, int publisher, Date createdAt)
        try {
//            bookDAO.insertBook(new Book(15,"1424","sfs","fs","QD",1,2, new Date()));
            bookDAO.selectBook(5);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }
}
