package hangdinh.librusmanagement.model;



import javax.validation.constraints.*;
import java.util.Date;

public class Book {
    @NotNull(message = "Id must not be empty")
    private int id;

    @NotEmpty(message = "ISBN must not be empty")
    @Pattern(regexp = "^(?:ISBN(?:-10)?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$)[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$",
            message = "ISBN must have 10 numbers and follow this format ex: 0-596-52068-9 or 0596520689 ")
    private String isbn;

    @NotEmpty(message = "Title must not be empty")
    private String title;

    @NotEmpty(message = "Author must not be empty")
    @Pattern(regexp = "^([A-Z]+[a-z]*[ ]?)+$",
            message = "Capitalized the first letter of Name Author")
    private String author;
    @NotEmpty(message = "Subject must not be empty")
    private String subject;


    @Max(value = 5)
    @Min(value = 1)
    private int language;

    @Max(value = 4)
    @Min(value = 1)
    private int publisher;
//    @FutureOrPresent(message = "createdAt must present or future")
    private Date createdAt;

    public Book(int id, String isbn, String title, String author, String subject, int language, int publisher, Date createdAt) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.subject = subject;
        this.language = language;
        this.publisher = publisher;
        this.createdAt = createdAt;
    }

    public Book() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public int getPublisher() {
        return publisher;
    }

    public void setPublisher(int publisher) {
        this.publisher = publisher;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", subject='" + subject + '\'' +
                ", language=" + language +
                ", publisher=" + publisher +
                ", createdAt=" + createdAt +
                '}';
    }
}
