package refApp.domain;

//import javax.persistence.Entity;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * A class for book reference.
 */

@Entity
@DiscriminatorValue(value = "book")
public class Book extends Reference {

    /**
     * Constructs a book with all the possible fields.
     *
     * @param title Title of a the book
     * @param authors Authors for book
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
     * @param tags Tags for reference
     */
    public Book(String title, List <Author> authors, String publisher, String year, String month, String edition, String volume, String series, String address, String note, String referenceId, List<Tag> tags) {
        super(title, authors, publisher, year, month, edition, volume, series, address, note, referenceId, tags);
    }

    /**
     * A constructor needed by the database.
     */
    Book() {
    }
    
    /**
     * Method for generating book-type reference metadata into bibtex syntax
     */    
    @Override
    public String toString() {
        return "@book{"+ this.printReferenceId() 
                + this.printValue("author", printAuthorNames()) 
                + this.printValue("title", this.getTitle())
                + this.printValue("year", this.getYear())
                + this.printValue("month", this.getMonth())
                + this.printValue("publisher", this.getPublisher())
                + this.printValue("volume", this.getVolume())
                + this.printValue("series", this.getSeries())
                + this.printValue("address", this.getAddress())
                + this.printValue("edition", this.getEdition())
                + "\n}\n";
    }

    /**
     * Get a printable "pretty" string of the books attributes.
     *
     * @return the String
     */
    @Override
    public String getPrettyString() {
        StringBuilder builder = new StringBuilder(super.getAuthorAndTitle());
        builder.append(super.getAttributeWithComma(super.publisher));
        if (isSet(super.address)) {
            builder.append(super.getAttributeWithComma(super.address));
        }
        builder.append(super.getAttributeWithPeriod(super.year));
        return builder.toString().trim();
    }
}
