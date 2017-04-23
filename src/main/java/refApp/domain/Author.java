package refApp.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Author(String authorName) {
        this.name = authorName;
    }

    /**
     * A constructor needed by the database.
     */
    Author() {
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        this.name = n;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
