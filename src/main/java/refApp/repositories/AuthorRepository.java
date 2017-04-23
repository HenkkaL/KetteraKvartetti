/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
