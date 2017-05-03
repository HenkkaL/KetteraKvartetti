package refApp.services.formatters;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import refApp.domain.Author;
import refApp.domain.Reference;
import refApp.domain.Tag;
import refApp.repositories.ReferenceRepository;

/**
 * Includes helper methods to format input to BibTeX form.
 *
 * @author pqkallio
 */
public class BibTeXFormatter implements Formatter {

    private final static String PAGE_DELIMITER = "--";
    private final CharacterMapper characterMapper;

    /**
     * Constructs a new BibTeXFormatter.
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
     * Uses a FileWriter to write references to a downloadable file.
     *
     */
    public void writeSelectedReferencesToFile(List<Reference> allReferences, Set<Long> selectedReferences) throws IOException {
        FileWriter fw = new FileWriter(new File("src/main/resources/downloadables/sigproc.bib"));
        for (Reference r : allReferences) {
            if (selectedReferences.contains(r.getId())) {
                fw.write(formatString(r.toString()));
                fw.write("\n");
            }
        }
        fw.close();
    }

    /**
     * Generates id for reference.
     *
     * @param params Reference parameters
     * @param referenceRepository Repository for references
     * @return unique id
     */
    public String generateId(Map<String, String> params, ReferenceRepository referenceRepository) {
        String name = formAuthorName(params.get("author"));
        String tempId = name + params.get("year");
        String id = tempId;
        char idChar = 'a';

        while (idReserved(id, referenceRepository)) {
            id = tempId + idChar;
            idChar++;
        }
        return id;
    }

    // Forms author name for generateId
    private String formAuthorName(String name) {
        String[] nameArray = name.split(" ");
        char firstLetterOfFirstName = nameArray[0].charAt(0);
        String lastName = nameArray[nameArray.length - 1];

        return firstLetterOfFirstName + "." + lastName;
    }

    // Checks if reference id is already reserved for generateId
    private boolean idReserved(String id, ReferenceRepository referenceRepository) {
        return referenceRepository.findByReferenceId(id) != null;
    }

    /**
     * Adds tags for reference.
     *
     * @param params Reference parameters
     * @return List of tags
     */
    public List<Tag> addTags(Map<String, String> params) {
        List<Tag> tags = new ArrayList();

        for (Map.Entry<String, String> param : params.entrySet()) {
            if (param.getKey().startsWith("tag")) {
                tags.add(new Tag(param.getValue()));
            }
        }
        return tags;
    }

    /**
     * Adds authors for reference.
     *
     * @param params Reference parameters
     * @return List of authors
     */
    public List<Author> addAuthors(Map<String, String> params) {
        List<Author> authors = new ArrayList();

        for (Map.Entry<String, String> param : params.entrySet()) {
            if (param.getKey().startsWith("author")) {
                authors.add(new Author(param.getValue()));
            }
        }
        return authors;
    }
}