package refApp.domain;

//import javax.persistence.Entity;

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

    /**
     * A constructor needed by the database.
     */
    Book() {
    }
    
    public String printEdition() {
        String ret = "";
        
        if(super.isSet(this.getEdition())) {
            ret = ",\nedition = {" + this.getEdition() + "}";
        }
        return ret;
    }
    //method now covers the required fields, but it will be expanded later to add the optional data
    @Override
    public String toString() {
//        String ret = "@book{" + this.getReferenceId() + ",\nauthor = {" + this.getAuthor().toString() + "},\ntitle = {" + this.getTitle() + "},\nyear = {" + this.getYear() + "},\npublisher = {" + this.getPublisher() + "}\n}\n";
        // if (getPages != null) {lisää tieto sivuista} ret += ....

        return "@book{" + this.getReferenceId() + ",\nauthor = {" + this.getAuthor().toString() + "},\ntitle = {" + this.getTitle() + "},\nyear = {" + this.getYear() + "},\npublisher = {" + this.getPublisher() + "}" + this.printEdition() + ",\n}\n";
    }

    @Override
    public String getPrettyString() {
        StringBuilder builder = new StringBuilder(super.getAuthorAndTitle());
        builder.append(super.getAttributeWithComma(super.publisher));
        if (isSet(super.address)) {
            builder.append(super.getAttributeWithComma(super.address));
        }
        builder.append(super.getAttributeWithPeriod(super.year));
        return builder.toString();
    }
}
