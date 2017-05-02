package refApp.services.formatters;

import java.util.List;
import java.util.Map;
import refApp.domain.Author;
import refApp.domain.Tag;
import refApp.repositories.ReferenceRepository;

/**
 * An interface designed to format strings from given parameters.
 *
 * @author pqkallio
 */
public interface Formatter {

    /**
     * Format a string from given parameter string.
     *
     * @param string the parameter string
     * @return the formatted string
     */
    public String formatString(String string);

    /**
     * Format a string representing a range of pages.
     *
     * @param pageStart the first page
     * @param pageEnd the last page
     * @return the formatted string
     */
    public String formatPageString(String pageStart, String pageEnd);

    /**
     * Generates id for reference.
     *
     * @param params Reference parameters
     * @param referenceRepository Reference repository
     * @return id
     */
    public String generateId(Map<String, String> params, ReferenceRepository referenceRepository);

    /**
     * Adds tags for reference.
     *
     * @param paramsReference parameters
     * @return tags as a list
     */
    public List<Tag> addTags(Map<String, String> params);

    /**
     * Adds authors for reference.
     *
     * @param params Reference parameters
     * @return authors as a list
     */
    public List<Author> addAuthors(Map<String, String> params);

}
