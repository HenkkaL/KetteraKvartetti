package refApp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Class for tagging references
 */
@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    /**
     * Constructs tag with tag name
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
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
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
