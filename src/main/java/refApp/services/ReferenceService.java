package refApp.services;

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
import refApp.domain.factories.ReferenceFactory;
import refApp.repositories.AuthorRepository;
import refApp.repositories.ReferenceRepository;
import refApp.repositories.TagRepository;
import refApp.services.formatters.BibTeXFormatter;
import refApp.services.formatters.Formatter;

/**
 * Service class for references.
 */
@Service
public class ReferenceService {

    @Autowired
    private ReferenceRepository referenceRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private TagRepository tagRepository;

    private final ReferenceFactory referenceFactory = new ReferenceFactory();
    
    /**
     * Method for adding a reference.
     *
     * @param params user given values for a reference
     */
    public void addReference(Map<String, String> params) {
        Formatter formatter = new BibTeXFormatter();
        String id = formatter.generateId(params, referenceRepository);
        List<Tag> tags = formatter.addTags(params);
        List<Author> authors = formatter.addAuthors(params);
        try {
            Reference reference = referenceFactory.create(params.get("type"), params, id, tags, authors);
            saveReference(reference);
        } catch (Exception e) {
            // Exception handling here
        }
    }

    /**
     * Saves refence to repository.
     *
     * @param ref Reference
     */
    public void saveReference(Reference ref) {
        saveAuthors(ref.getAuthors());
        saveTags(ref.getTags());
        this.referenceRepository.save(ref);
    }
    
    public void deleteReference(String refId) {
        Reference temp = this.referenceRepository.findByReferenceId(refId);
        this.referenceRepository.delete(temp);
    }

    /**
     * Saves authors related to reference to author repository.
     *
     * @param authors Authors that are saved
     */
    public void saveAuthors(List<Author> authors) {
        authorRepository.save(authors);
    }

    /**
     * Saves tags to tag repository.
     *
     * @param tags Tags that are saved
     */
    public void saveTags(List<Tag> tags) {
        tagRepository.save(tags);
    }

    /**
     * Returns reference repository.
     *
     * @return Reference repository
     */
    public ReferenceRepository getReferenceRepo() {
        return this.referenceRepository;
    }

    /**
     * Returns author repository.
     *
     * @return Author repository
     */
    public AuthorRepository getAuthorRepository() {
        return authorRepository;
    }

    /**
     * Returns tag repository.
     *
     * @return Tag repository
     */
    public TagRepository getTagRepository() {
        return tagRepository;
    }

    /**
     * Deletes reference from reference repository.
     *
     * @param ref Reference to be deleted
     */
    public void deleteReference(Reference ref) {
        referenceRepository.delete(ref);
    }

}
