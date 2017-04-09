
package refApp.services.formatters;

/**
 * An interface designed to format strings from given parameters.
 * 
 * @author pqkallio
 */
public interface Formatter {
    /**
     * Format a string from given parameter string
     * 
     * @param string the parameter string
     * @return the formatted string
     */
    public String formatString(String string);
    
    /**
     * Format a string representing a range of pages-
     * 
     * @param pageStart the first page
     * @param pageEnd the last page
     * @return the formatted string
     */
    public String formatPageString(String pageStart, String pageEnd);
}
