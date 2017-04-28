package refApp.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import refApp.domain.Author;

/**
 *
 * @author kasimiraula
 */
public interface AuthorRepository extends JpaRepository<Author, Long>{
    List<Author> findByName(String name);
}
