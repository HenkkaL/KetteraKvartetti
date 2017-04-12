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

//    private String hasVolume() {
//        String ret = "";
//        
//        if (this.getVolume() != null) {
//            ret = "{volume = " + this.getVolume() + "},\n";
//        }
//        return ret;
//    }
//    @article{fox,
// author = {Fox, Armando and Patterson, David},
// title = {Crossing the software education chasm},
// journal = {Communications of ACM},
// volume = {55},
// number = {5},
// month = may,
// year = {2012},
// pages = {44--49},
// publisher = {ACM},
// address = {New York, NY, USA}
// }

    @Override
    public String toString() {
        return "@article{" + this.getReferenceId() + ",\nauthor = {" + this.getAuthor().toString() + "},\ntitle = {" + this.getTitle() + "},\nyear = {" + this.getYear() + "},\npublisher = {" + this.getPublisher() + "},\n}\n";
    }
}
