package refApp.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * Class for tagging references
 */
@Entity
public class Tag extends AbstractPersistable<Long> {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(fetch=FetchType.EAGER, mappedBy = "tags")
    private List<Reference> references;
    

    /**
     * Constructs tag with tag name
     *
     * @param name
     */
    public Tag(String name) {
        this.name = name;
    }

    /**
     * A constructor needed by the database.
     */
    public Tag() {
        
    }

    /**
     *
     * @return tag name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets tag name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return References for tag
     */
    public List<Reference> getReferences() {
        if (references == null) {
            references = new ArrayList<Reference>();
        }
        return references;
    }

    
    /**
     *
     * @return tag name in string format
     */
    @Override
    public String toString() {
        return this.getName();
    }
}
