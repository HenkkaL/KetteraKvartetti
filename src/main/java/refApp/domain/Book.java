package refApp.domain;

/**
 * A class for book reference.
 */
public class Book extends Reference {

    /**
     * Constructs a book with all the possible fields.
     *
     * @param title Title of a the book
     * @param author Author of the book
     * @param publisher Publisher of the book
     * @param year The year of publication
     * @param month The month of publication
     * @param edition The edition of a book, long form (such as "First" or
     * "Second")
     * @param volume The volume of a multi-volume book
     * @param series The series of books the book was published in
     * @param address Publisher's address (usually just the city, but can be the
     * full address for lesser-known publishers)
     * @param note Miscellaneous extra information
     * @param referenceId Reference id for the book
     */
    public Book(String title, Author author, String publisher, String year, String month, String edition, String volume, String series, String address, String note, String referenceId) {
        super(title, author, publisher, year, month, edition, volume, series, address, note, referenceId);
    }
}
