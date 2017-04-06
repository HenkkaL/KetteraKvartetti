package refApp.services.formatters;

/**
 *
 * @author pqkallio
 */
public class BibTeXFormatter implements Formatter {
    private final static String PAGE_DELIMITER = "--";
    private final static String STRING_START = "{";
    private final static String STRING_END = "}";
    private final CharacterMapper characterMapper;
    
    public BibTeXFormatter() {
        this.characterMapper = new BibTeXCharacterMapper();
    }

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

    @Override
    public String formatPageString(int pageStart, int pageEnd) {
        String pages = pageStart + PAGE_DELIMITER + pageEnd;
        return addDelimiters(pages);
    }

    private String addDelimiters(String string) {
        StringBuilder builder = new StringBuilder(STRING_START);
        builder.append(string);
        builder.append(STRING_END);
        return builder.toString();
    }
}
