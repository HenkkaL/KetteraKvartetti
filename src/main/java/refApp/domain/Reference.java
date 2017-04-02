package refApp.domain;

public abstract class Reference {

    private Author author;
    private String title;
    private String publisher;
    private int year;

    public Reference(String title, Author auth, String publisher, int year) {
        this.title = title;
        this.author = auth;
        this.publisher = publisher;
        this.year = year;
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


