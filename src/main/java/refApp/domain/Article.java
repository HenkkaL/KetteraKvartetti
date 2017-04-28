package refApp.domain;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * A class for article reference.
 */
@Entity
@DiscriminatorValue(value = "article")
public class Article extends Reference {

    /**
     * Constructs an article with all the possible fields.
     *
     * @param title Title of article
     * @param authors Authors for article
     * @param journal The journal or magazine the work was published in
     * @param year Publication year
     * @param month Publication month
     * @param volume The volume of a journal
     * @param number The "(issue) number" of a journal,if applicable. (Most
     * publications have a "volume", but no "number" field.)
     * @param pages Page numbers
     * @param note Miscellaneous extra information
     * @param referenceId Reference id for the article
     * @param tags Tags for reference
     */
    public Article(String title, List <Author> authors, String journal, String year, String month, String volume, String number, String pages, String note, String referenceId, List<Tag> tags) {
        super(title, authors, journal, year, month, volume, number, pages, note, referenceId, tags);
    }

    /**
     * A constructor needed by the database.
     */
    Article() {
    }


    /**
     * Method for generating article-type reference metadata into bibtex syntax
     */       
    @Override
    public String toString() {
        return "@article{" + this.printReferenceId() 
                + this.printValue("author", this.getAuthors().get(0).getName()) 
                + this.printValue("title", this.getTitle())
                + this.printValue("journal", this.getJournal())
                + this.printValue("volume", this.getVolume())
                + this.printValue("number", this.getNumber())
                + this.printValue("year", this.getYear())
                + this.printValue("month", this.getMonth())
                + this.printValue("pages", this.getPages())
                + this.printValue("note", this.getNote())
                + "\n}\n";
    }

    @Override
    public String getPrettyString() {
        StringBuilder builder = new StringBuilder(super.getAuthorAndTitle());
        builder.append(super.getAttributeWithComma(super.journal));
        appendVolumeNumberAndPages(builder);
        builder.append(super.getAttributeWithPeriod(super.year));
        return builder.toString().trim();
    }

    private void appendVolumeNumberAndPages(StringBuilder builder) {
        if (isSet(super.volume)) {
            builder.append(super.volume);
            if (isSet(super.number)) {
                String numberStr = "(" + super.number + ")";
                builder.append(numberStr);
            }
            if (isSet(super.pages)) {
                String pagesStr = ":" + super.pages;
                builder.append(pagesStr);
            }
            builder.append(", ");
        }
    }
}
