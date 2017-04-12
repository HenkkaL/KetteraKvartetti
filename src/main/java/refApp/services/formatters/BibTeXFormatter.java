package refApp.services.formatters;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import refApp.domain.Reference;

/**
 * Includes helper methods to format input to BibTeX form.
 *
 * @author pqkallio
 */
public class BibTeXFormatter implements Formatter {

    private final static String PAGE_DELIMITER = "--";
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

        return builder.toString();
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
        return pages;
    }

    /**
     * Uses a FileWriter to write references to a downloadable file
     *
     */
    public void writeReferencesToFile(List<Reference> ref) throws IOException {
        FileWriter fw = new FileWriter(new File("src/main/resources/downloadables/sigproc.bib"));
        for (Reference r : ref) {
            fw.write(formatString(r.toString()));
            fw.write("\n");
        }
        fw.close();
    }
}
