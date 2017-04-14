package refApp.domain;

/**
 * An abstract class for references.
 */
public abstract class Reference {

    protected String title;
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

    /**
     * Get a printable "pretty" string of the references attributes.
     * 
     * @return the String
     */
    public abstract String getPrettyString();
    
    /**
     * Constructor model with all possible fields used in references.
     */
    public Reference(String title, Author author, String publisher, String year, String month, String journal, String volume, String number, String series, String edition, String editor, String inproceedingsBookTitle, String organization, String pages, String address, String note, String referenceId) {
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
     */
    public Reference(String title, Author author, String publisher, String year, String month, String edition, String volume, String series, String address, String note, String referenceId) {
        this(title, author, publisher, year, month, null, volume, null, series, edition, null, null, null, null, address, note, referenceId);
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
     */
    public Reference(String title, Author author, String journal, String year, String month, String volume, String number, String pages, String note, String referenceId) {
        this(title, author, null, year, month, journal, volume, number, null, null, null, null, null, pages, null, note, referenceId);
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
     */
    public Reference(String title, Author author, String inproceedingsBookTitle, String year, String month, String editor, String volume, String series, String pages, String organization, String publisher, String address, String note, String referenceId) {
        this(title, author, publisher, year, month, null, volume, null, series, null, editor, inproceedingsBookTitle, organization, pages, address, note, referenceId);
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
}
