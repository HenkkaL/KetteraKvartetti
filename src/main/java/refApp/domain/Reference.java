package refApp.domain;

/**
 * An abstract class for references.
 */
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "reference_type")
public abstract class Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    protected String title;
    @ManyToOne
    @JoinColumn
    protected Author author;
    protected String publisher;
    protected String year;
    protected String month;
    protected String journal;
    protected String volume;
    protected String number;
    protected String series;
    protected String edition;
    protected String editor;
    protected String inproceedingsBookTitle;
    protected String organization;
    protected String pages;
    protected String address;
    protected String note;
    protected String referenceId;
    @ManyToMany(fetch = FetchType.EAGER)
    protected List<Tag> tags;

    /**
     * Get a printable "pretty" string of the references attributes.
     *
     * @return the String
     */
    public abstract String getPrettyString();

    /**
     * Constructor model with all possible fields used in references.
     */
    Reference() {

    }

    public Reference(String title, Author author, String publisher, String year, String month, String journal, String volume, String number, String series, String edition, String editor, String inproceedingsBookTitle, String organization, String pages, String address, String note, String referenceId, List<Tag> tags) {

        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.month = month;
        this.journal = journal;
        this.volume = volume;
        this.number = number;
        this.series = series;
        this.edition = edition;
        this.editor = editor;
        this.inproceedingsBookTitle = inproceedingsBookTitle;
        this.organization = organization;
        this.pages = pages;
        this.address = address;
        this.note = note;
        this.referenceId = referenceId;
        this.tags = tags;
    }

    /**
     * Constructor model for a book reference.
     *
     * @param title A book title
     * @param author Name(s) of the author(s)
     * @param publisher The publishers name
     * @param year Publication year
     * @param month Publication month
     * @param edition The edition of a book
     * @param volume The volume of a journal or multi-volume book
     * @param series The series of books the book was published in
     * @param address Publisher's address
     * @param note Miscellaneous extra information
     * @param referenceId Reference id for the publication
     * @param tags Tags for reference
     */
    public Reference(String title, Author author, String publisher, String year, String month, String edition, String volume, String series, String address, String note, String referenceId, List<Tag> tags) {
        this(title, author, publisher, year, month, null, volume, null, series, edition, null, null, null, null, address, note, referenceId, tags);
    }

    /**
     * Constructor model for an article reference.
     *
     * @param title Article title
     * @param author Name(s) of the author(s)
     * @param journal The journal or magazine the work was published in
     * @param year Publication year
     * @param month Publication month
     * @param volume The volume of a journal or multi-volume book
     * @param number The "(issue) number" of a journal,if applicable. (Most
     * publications have a "volume", but no "number" field.)
     * @param pages Page numbers
     * @param note Miscellaneous extra information
     * @param referenceId Reference id for the article
     * @param tags Tags for reference
     */
    public Reference(String title, Author author, String journal, String year, String month, String volume, String number, String pages, String note, String referenceId, List<Tag> tags) {
        this(title, author, null, year, month, journal, volume, number, null, null, null, null, null, pages, null, note, referenceId, tags);
    }

    /**
     * Constructor model for an inproceedings reference.
     *
     * @param title Inproceedings title
     * @param author Name(s) of the author(s)
     * @param inproceedingsBookTitle The title of the book, if only part of it
     * is being cited
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
     * @param tags Reference tags
     */
    public Reference(String title, Author author, String inproceedingsBookTitle, String year, String month, String editor, String volume, String series, String pages, String organization, String publisher, String address, String note, String referenceId, List<Tag> tags) {
        this(title, author, publisher, year, month, null, volume, null, series, null, editor, inproceedingsBookTitle, organization, pages, address, note, referenceId, tags);
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

    public String getYear() {
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

    public String getMonth() {
        return month;
    }

    public String getEdition() {
        return edition;
    }

    public String getEditor() {
        return editor;
    }

    public String getInproceedingsBookTitle() {
        return inproceedingsBookTitle;
    }

    public String getJournal() {
        return journal;
    }

    public String getNote() {
        return note;
    }

    public String getNumber() {
        return number;
    }

    public String getOrganization() {
        return organization;
    }

    public String getSeries() {
        return series;
    }

    public String getVolume() {
        return volume;
    }

    public List<Tag> getTags() {
        if (tags == null) {
            tags = new ArrayList<Tag>();
        }
        return tags;
    }

    public Long getId() {
        return id;
    }
    
        /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * @param journal the journal to set
     */
    public void setJournal(String journal) {
        this.journal = journal;
    }

    /**
     * @param volume the volume to set
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @param series the series to set
     */
    public void setSeries(String series) {
        this.series = series;
    }

    /**
     * @param edition the edition to set
     */
    public void setEdition(String edition) {
        this.edition = edition;
    }

    /**
     * @param editor the editor to set
     */
    public void setEditor(String editor) {
        this.editor = editor;
    }

    /**
     * @param inproceedingsBookTitle the inproceedingsBookTitle to set
     */
    public void setInproceedingsBookTitle(String inproceedingsBookTitle) {
        this.inproceedingsBookTitle = inproceedingsBookTitle;
    }

    /**
     * @param organization the organization to set
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
     * @param pages the pages to set
     */
    public void setPages(String pages) {
        this.pages = pages;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    protected boolean isSet(String parameter) {
        return (parameter != null & parameter.length() > 0);
    }

    protected String getAuthorAndTitle() {
        return this.author + ". " + this.title + ". ";
    }

    protected String getAttributeWithComma(String parameter) {
        return getAttributeWithCharacter(parameter, ',');
    }

    protected String getAttributeWithPeriod(String parameter) {
        return getAttributeWithCharacter(parameter, '.');
    }

    protected String getAttributeWithCharacter(String parameter, char character) {
        return parameter + character + " ";
    }
    
    protected String printValue(String attribute, String value) {
        String ret = "";
        if (this.isSet(value)) {
            ret = "\n" + attribute + " = {" + value + "},";
        }
        return ret;
    }
   
    protected String printReferenceId() {
        String ret = "";
        if (this.isSet(this.getReferenceId())) {
            ret = this.getReferenceId()+ ",";
        }
        return ret;
    }         

    public String getTagsForHtml() {
        StringBuilder builder = new StringBuilder();
        for (Tag tag : tags) {
            builder.append(tag);
            builder.append(" ");
        }
        return builder.toString().trim();
    }
}
