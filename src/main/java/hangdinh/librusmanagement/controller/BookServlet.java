package hangdinh.librusmanagement.controller;

import hangdinh.librusmanagement.dao.BookDAO;
import hangdinh.librusmanagement.dao.LanguageDAO;
import hangdinh.librusmanagement.dao.PublisherDAO;
import hangdinh.librusmanagement.model.Book;
import hangdinh.librusmanagement.model.Language;
import hangdinh.librusmanagement.model.Publisher;
import hangdinh.librusmanagement.utils.ValidateUtils;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.function.BiConsumer;

@WebServlet (name = "BookServlet", urlPatterns ="/book")
public class BookServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private BookDAO bookDAO;
    private LanguageDAO languageDAO;
    private PublisherDAO publisherDAO;
    private String errors ="";

    @Override
    public void init() throws ServletException {
        bookDAO = new BookDAO();
        languageDAO = new LanguageDAO();
        publisherDAO = new PublisherDAO();
        if(getServletContext().getAttribute("listLanguage")==null){
            getServletContext().setAttribute("listLanguage", languageDAO.selectAllLanguage());
        }
        if(getServletContext().getAttribute("listPublisher")==null){
            getServletContext().setAttribute("listPublisher", publisherDAO.selectAllPublisher());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteBook(request, response);
                    break;
                default:
                    listBook(request, response);
                    break;
            }
        }catch (SQLException ex){
            throw new ServletException(ex);
        }

    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action ==null){
            action="";
        }
        try {
            switch (action){
                case "create":
                    insertBook(request,response);
                    break;
                case "edit":
                    updateBook(request,response);
                    break;
            }
        } catch (SQLException ex){
            throw new ServletException(ex);
        }
    }


    private void listBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Book> listBook = bookDAO.selectAllBooks();
        request.setAttribute("listBook", listBook);
        System.out.println("listlanguage");
        List<Language> languages = (List<Language>) getServletContext().getAttribute("listLanguage");
        List<Publisher> publishers = (List<Publisher>) getServletContext().getAttribute("listPublisher");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin/book/listbook.jsp");
        dispatcher.forward(request, response);
    }

    private void insertBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException{
        Book book = new Book();
        boolean flag = true;
        Map<String, String> hashMap = new HashMap<String, String>();
        try {
            String isbn = request.getParameter("isbn");
            book.setIsbn(isbn);
            String title = request.getParameter("title");
            book.setTitle(title);
            String author =  request.getParameter("author");
            book.setAuthor(author);
            String subject = request.getParameter("subject");
            book.setSubject(subject);
            int idLanguage = Integer.parseInt(request.getParameter("idLanguage"));
            book.setLanguage(idLanguage);
            int idPublisher = Integer.parseInt(request.getParameter("idPublisher"));
            book.setPublisher(idPublisher);
            java.util.Date createdAt = new java.util.Date();
            book.setCreatedAt(createdAt);

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator = validatorFactory.getValidator();

            Set<ConstraintViolation<Book>> constraintViolations = validator.validate(book);
            System.out.println("Book info: " + book);
            if (!constraintViolations.isEmpty()) {

                errors  = "<ul>";
                // constraintViolations is has error
                for (ConstraintViolation<Book> constraintViolation : constraintViolations) {
                    errors += "<li>" + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage()
                            + "</li>";
                }
                errors += "</ul>";


                request.setAttribute("book", book);
                request.setAttribute("errors", errors);

                List<Language> listLanguage = languageDAO.selectAllLanguage();
                request.setAttribute("listLanguage", listLanguage);

                List<Publisher> listPublisher = publisherDAO.selectAllPublisher();
                request.setAttribute("listPublisher",listPublisher);

                request.getRequestDispatcher("/WEB-INF/admin/book/create.jsp").forward(request, response);
            }else{
                if (languageDAO.selectLanguage(idLanguage)==null){
                    flag = false;
                    hashMap.put("language","Language Invalid");
                }
                if (publisherDAO.selectPublisher(idPublisher) ==null){
                    flag = false;
                    hashMap.put("publisher","Publisher Invalid");
                }
                if (flag){
                    bookDAO.insertBook(book);
                    Book book1= new Book();
                    request.setAttribute("book",book1);
                    request.getRequestDispatcher("/WEB-INF/admin/book/create.jsp").forward(request,response);
                }else {
                    errors = "<ul>";
                    // One more field has error
                    hashMap.forEach(new BiConsumer<String, String>() {
                        @Override
                        public void accept(String keyError, String valueError) {
                            errors += "<li>"  + valueError
                                    + "</li>";

                        }
                    });
                    errors +="</ul>";

                    request.setAttribute("book", book);
                    request.setAttribute("errors", errors);


                    System.out.println(this.getClass() + " !constraintViolations.isEmpty()");
                    request.getRequestDispatcher("/WEB-INF/admin/book/create.jsp").forward(request, response);
                }

            }


        }catch (NumberFormatException ex){
            System.out.println(this.getClass() + " NumberFormatException: Book info from request: " + book);
            System.out.println("NumberFormatException Book info: " + book);
            errors = "<ul>";
            errors += " <li>" + "Invalid Format"
                    + "</li>";

            errors += "</ul>";
        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book existingBook = bookDAO.selectBook(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin/book/edit.jsp");
        request.setAttribute("book", existingBook);
        dispatcher.forward(request, response);

    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Book book = new Book();
        request.setAttribute("book",book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin/book/create.jsp");
        dispatcher.forward(request, response);
    }
    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String subject = request.getParameter("subject");
        int language = Integer.parseInt(request.getParameter("language"));
        int publisher = Integer.parseInt(request.getParameter("publisher"));
        Date createdAt = new Date();
        Book book = new Book(id, isbn, title,author, subject,language,publisher,createdAt);
        bookDAO.updateBook(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin/book/edit.jsp");
        dispatcher.forward(request, response);

    }
    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        bookDAO.deleteBook(id);
        List<Book> listBook = bookDAO.selectAllBooks();
        request.setAttribute("listBook", listBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin/book/listbook.jsp");
        dispatcher.forward(request, response);
    }
}
