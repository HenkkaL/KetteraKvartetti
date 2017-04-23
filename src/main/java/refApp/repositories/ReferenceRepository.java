/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import refApp.domain.Reference;

/**
 *
 * @author kasimiraula
 */
public interface ReferenceRepository extends JpaRepository<Reference, Long>{
    
}
