package refApp.domain;

public abstract class Reference {

    private Author author;
    private String title;
    private String publisher;
    private int year;
    private String pages;
    private String address;
    private String referenceId;

    public Reference(String title, Author auth, String publisher, int year, String pages, String address, String referenceId) {
        this.title = title;
        this.author = auth;
        this.publisher = publisher;
        this.year = year;
        this.address = address;
        this.pages = pages;
        this.referenceId = referenceId;
    }

    public Reference(String title, Author auth, String publisher, int year) {
        this(title, auth, publisher, year, null, null, null);
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

    public String getAddress() {
        return address;
    }

    public String getPages() {
        return pages;
    }  

    public String getReferenceId() {
        return referenceId;
    }
}
