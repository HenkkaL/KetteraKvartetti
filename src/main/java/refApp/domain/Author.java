package refApp.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Class for author
 */
@Entity
public class Author extends AbstractPersistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "authors")
    private List<Reference> references;

    /**
     * Constructs author with name
     *
     * @param authorName
     */
    public Author(String authorName) {
        this.name = authorName;
        this.references = new ArrayList<>();
    }

    /**
     * A constructor needed by the database.
     */
    Author() {
    }

    /**
     *
     * @return Name of the author
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name for author
     *
     * @param n Name
     */
    public void setName(String n) {
        this.name = n;
    }

    /**
     * @return References for author
     */
    public List<Reference> getReferences() {
        if (references == null) {
            references = new ArrayList<Reference>();
        }
        return references;
    }

    /**
     * Adds reference to author
     *
     * @param reference Reference
     */
    public void addReference(Reference reference) {
        if (reference != null) {
            this.references.add(reference);
        }
    }

    /**
     *
     * @return Author in String format
     */
    @Override
    public String toString() {
        return this.getName();
    }
}
