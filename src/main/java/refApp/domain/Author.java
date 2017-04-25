package refApp.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    @OneToMany(fetch=FetchType.EAGER)
    private List<Reference> references;

    /**
     * Constructs author with name
     * @param authorName 
     */
    public Author(String authorName) {
        this.name = authorName;
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
     * @param n Name 
     */
    public void setName(String n) {
        this.name = n;
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
