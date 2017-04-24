package refApp.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import refApp.domain.Tag;


public interface TagRepository extends JpaRepository<Tag, Long>{
    List<Tag> findByName(String name);
}
