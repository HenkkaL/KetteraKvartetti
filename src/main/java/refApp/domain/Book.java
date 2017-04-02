package refApp.domain;

public class Book extends Reference {

    public Book(String title, Author author, String publisher, int yearpublished, String address, String pages) {
        super(title, author, publisher, yearpublished, address, pages);
    }

    public Book(String title, Author author, String publisher, int yearpublished) {
        super(title, author, publisher, yearpublished);
    }
}
