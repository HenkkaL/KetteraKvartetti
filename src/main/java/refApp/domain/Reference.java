package refApp.domain;

public abstract class Reference {

    private Author author;
    private String title;
    private String publisher;
    private int year;
    private String pages;
    private String address;

    public Reference(String title, Author auth, String publisher, int year, String pages, String address) {
        this.title = title;
        this.author = auth;
        this.publisher = publisher;
        this.year = year;
        this.address = address;
        this.pages = pages;
    }

    public Reference(String title, Author auth, String publisher, int year) {
        this(title, auth, publisher, year, null, null);
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

}
