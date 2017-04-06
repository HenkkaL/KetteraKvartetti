
package refApp.services.formatters;

/**
 *
 * @author pqkallio
 */
public interface Formatter {
    public String formatString(String string);
    public String formatPageString(int pageStart, int pageEnd);
}
