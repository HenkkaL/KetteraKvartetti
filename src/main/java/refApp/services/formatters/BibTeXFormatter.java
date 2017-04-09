package refApp.services.formatters;

/**
 * Includes helper methods to format input to BibTeX form.
 * 
 * @author pqkallio
 */
public class BibTeXFormatter implements Formatter {
    private final static String PAGE_DELIMITER = "--";
    private final static String STRING_START = "{";
    private final static String STRING_END = "}";
    private final CharacterMapper characterMapper;
    
    /**
     * Constructs a new BibTeXFormatter
     */
    public BibTeXFormatter() {
        this.characterMapper = new BibTeXCharacterMapper();
    }

    /**
     * Formats a String object to another String that can be inserted into a
     * BibTeX file.
     * 
     * @param string the String object to format
     * @return the formatted String object
     */
    @Override
    public String formatString(String string) {
        if (string == null) {
            return null;
        }
        
        char c;
        String toAppend;
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < string.length(); i++) {
            c = string.charAt(i);
            
            if (Character.isAlphabetic(c)) {
                toAppend = characterMapper.getStringMappedFor(c);
            } else {
                toAppend = Character.toString(c);
            }
            
            builder.append(toAppend);
        }
        
        return addDelimiters(builder.toString());
    }

    /**
     * Formats a String object that can be used as the range of a reference's
     * pages in a BibTeX file.
     * 
     * @param pageStart the first page
     * @param pageEnd the last page
     * @return formatted string
     */
    @Override
    public String formatPageString(String pageStart, String pageEnd) {
        String pages = pageStart + PAGE_DELIMITER + pageEnd;
        return addDelimiters(pages);
    }

    /**
     * Adds the string delimiters required by the BibTeX form.
     * 
     * @param string the string to format
     * @return the formatted string
     */
    private String addDelimiters(String string) {
        StringBuilder builder = new StringBuilder(STRING_START);
        builder.append(string);
        builder.append(STRING_END);
        return builder.toString();
    }
}
