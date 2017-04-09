package refApp.domain;

/**
 * A class for article reference.
 */
public class Article extends Reference {

    /**
     * Constructs an article with all the possible fields.
     *
     * @param title Title of article
     * @param author Author(s) of article
     * @param journal The journal or magazine the work was published in
     * @param year Publication year
     * @param month Publication month
     * @param volume The volume of a journal
     * @param number The "(issue) number" of a journal,if applicable. (Most
     * publications have a "volume", but no "number" field.)
     * @param pages Page numbers
     * @param note Miscellaneous extra information
     * @param referenceId Reference id for the article
     */
    public Article(String title, Author author, String journal, String year, String month, String volume, String number, String pages, String note, String referenceId) {
        super(title, author, journal, year, month, volume, number, pages, note, referenceId);
    }
}
