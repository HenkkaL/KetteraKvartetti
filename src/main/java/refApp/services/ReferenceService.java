package refApp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import refApp.domain.Article;
import refApp.domain.Author;
import refApp.domain.Book;
import refApp.domain.Inproceedings;
import refApp.domain.Reference;
import refApp.domain.Tag;
import refApp.repositories.AuthorRepository;
import refApp.repositories.ReferenceRepository;
import refApp.repositories.TagRepository;
import refApp.services.formatters.BibTeXFormatter;
import refApp.services.formatters.Formatter;

/**
 * Service class for references
 */
@Service
public class ReferenceService {

    @Autowired
    private ReferenceRepository referenceRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private TagRepository tagRepository;

    /**
     * Method for adding a reference
     *
     * @param params user given values for a reference
     */
    public void addReference(Map<String, String> params) {   
        System.out.println(params);
        Formatter formatter = new BibTeXFormatter();
        String id = formatter.generateId(params, referenceRepository);
        List<Tag> tags = formatter.addTags(params);

        switch (params.get("type")) {
            case "article":
                saveReference(new Article(params.get("title"), new Author(params.get("author")), params.get("journal"), params.get("year"), params.get("month"), params.get("volume"), params.get("number"), params.get("pages_start").length() > 0 ? formPageNo(params.get("pages_start"), params.get("pages_end")) : "", params.get("note"), id, tags));
                break;
            case "book":
                saveReference(new Book(params.get("title"), new Author(params.get("author")), params.get("publisher"), params.get("year"), params.get("month"), params.get("edition"), params.get("volume"), params.get("series"), params.get("address"), params.get("note"), id, tags));
                break;
            case "inproceedings":
                saveReference(new Inproceedings(params.get("title"), new Author(params.get("author")), params.get("book_title"), params.get("year"), params.get("month"), params.get("editor"), params.get("volume"), params.get("series"), params.get("pages_start").length() > 0 ? formPageNo(params.get("pages_start"), params.get("pages_end")) : "", params.get("organization"), params.get("publisher"), params.get("address"), params.get("note"), id, tags));
                break;
        }
    }

    public void saveReference(Reference ref) {
        saveAuthor(ref.getAuthor());
        saveTags(ref.getTags());

        this.referenceRepository.save(ref);
    }

    public void saveAuthor(Author a) {
        authorRepository.save(a);
    }

    public void saveTags(List<Tag> tags) {
        tagRepository.save(tags);
    }

    public ReferenceRepository getReferenceRepo() {
        return this.referenceRepository;
    }

    public AuthorRepository getAuthorRepository() {
        return authorRepository;
    }

    public TagRepository getTagRepository() {
        return tagRepository;
    }

    private String formPageNo(String start, String end) {
        return start + "-" + end;
    }
}
