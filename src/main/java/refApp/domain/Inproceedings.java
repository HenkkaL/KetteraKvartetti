package refApp.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * A class for Inproceedings reference.
 */
@Entity
@DiscriminatorValue(value = "inproceedings")
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

    /**
     * A constructor needed by the database.
     */
    Inproceedings() {
    }

    private String printEditor() {
        String ret = "";
        if (this.isSet(this.getEditor())) {
            ret = "\neditor = {" + this.getEditor()+ "},";
        }
        return ret;
    }
    

    private String printInproceedingsBookTitle() {
        String ret = "";
        if (this.isSet(this.getInproceedingsBookTitle())) {
            ret = "\nbooktitle = {" + this.getInproceedingsBookTitle() + "},";
        }
        return ret;
    }    
    
    private String printOrganization() {
        String ret = "";
        if (this.isSet(this.getOrganization())) {
            ret = "\norganization = {" + this.getOrganization()+ "},";
        }
        return ret;
    }       

    /**
     * Method for generating inproceedings-type reference metadata into bibtex syntax
     */       
    @Override
    public String toString() {
        return "@Inproceedings{" + this.getReferenceId() + ","
                + "\nauthor = {" + this.getAuthor().toString() + "},"
                + "\ntitle = {" + this.getTitle() + "},"
                + this.printInproceedingsBookTitle() 
                + this.printEditor() 
                + this.printVolume() 
                + this.printSeries() 
                + this.printPages()
                + this.printAddress()
                + this.printOrganization()
                + "\npublisher = {" + this.getPublisher() + "},"
                + "\nyear = {" + this.getYear() + "},"
                + this.printMonth()
                + this.printNote()
                + "\n}\n";
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

        return builder.toString().trim();
    }

}
