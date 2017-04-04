package refApp.domain;

public class Book extends Reference {

    public Book(String title, Author author, String publisher, int yearpublished, String pages, String address, String referenceId) {
        super(title, author, publisher, yearpublished, pages, address, referenceId);
    }

    public Book(String title, Author author, String publisher, int yearpublished) {
        super(title, author, publisher, yearpublished);
    }
}
