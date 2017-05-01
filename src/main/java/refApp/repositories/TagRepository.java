package refApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import refApp.domain.Tag;


public interface TagRepository extends JpaRepository<Tag, Long>{
    Tag findByName(String name);
}
