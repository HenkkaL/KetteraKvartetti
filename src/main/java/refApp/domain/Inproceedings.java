package refApp.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * A class for Inproceedings reference.
 */
@Entity
@DiscriminatorValue(value = "improceedings")
public class Inproceedings extends Reference {

    /**
     * Constructs an inproceedings with all the possible fields.
     *
     * @param title Inproceedings title
     * @param author Name(s) of the author(s)
     * @param bookTitle The title of the book, if only part of it is being cited
     * @param year Publication year
     * @param month Publication month
     * @param editor The name(s) of the editor(s)
     * @param volume The volume of a journal or multi-volume book
     * @param series The series of books the book was published in
     * @param pages Page numbers
     * @param organization The conference sponsor
     * @param publisher The publishers name
     * @param address Publisher's address
     * @param note Miscellaneous extra information
     * @param referenceId Reference id for the publication
     */
    public Inproceedings(String title, Author author, String bookTitle, String year, String month, String editor, String volume, String series, String pages, String organization, String publisher, String address, String note, String referenceId) {
        super(title, author, bookTitle, year, month, editor, volume, series, pages, organization, publisher, address, note, referenceId);
    }
    
    Inproceedings() {
    }

    @Override
    public String toString() {
        return "@Inproceedings{" + this.getReferenceId() + ",\nauthor = {" + this.getAuthor().toString() + "},\ntitle = {" + this.getTitle() + "},\nyear = {" + this.getYear() + "},\npublisher = {" + this.getPublisher() + "},\n}\n";
    }

    @Override
    public String getPrettyString() {
        StringBuilder builder = new StringBuilder(super.getAuthorAndTitle());
        builder.append("In ");
        builder.append(super.inproceedingsBookTitle);
        if (isSet(super.pages)) {
            builder.append(", pages ");
            builder.append(super.pages);
        }
        builder.append(". ");
        if (isSet(super.publisher)) {
            builder.append(super.getAttributeWithComma(super.publisher));
        }
        builder.append(super.getAttributeWithPeriod(super.year));
        
        return builder.toString();
    }

}
