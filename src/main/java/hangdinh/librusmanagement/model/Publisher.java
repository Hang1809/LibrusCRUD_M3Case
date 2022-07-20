package hangdinh.librusmanagement.model;

public class Publisher {
    private int id;
    private String publisher;

    public Publisher(int id, String publisher) {
        this.id = id;
        this.publisher = publisher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
