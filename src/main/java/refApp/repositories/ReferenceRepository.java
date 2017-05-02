package refApp.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import refApp.domain.Reference;

/**
 *
 * @author kasimiraula
 */
public interface ReferenceRepository extends JpaRepository<Reference, Long> {

    List<Reference> findByTitle(String title);

    Reference findByReferenceId(String id);
}
