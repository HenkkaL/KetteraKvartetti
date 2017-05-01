package refApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import refApp.domain.Author;

/**
 *
 * @author kasimiraula
 */
public interface AuthorRepository extends JpaRepository<Author, Long>{
    Author findByName(String name);
}
