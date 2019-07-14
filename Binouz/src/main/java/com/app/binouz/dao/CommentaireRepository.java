
package com.app.binouz.dao;

import com.app.binouz.model.Commentaire;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public interface CommentaireRepository extends CrudRepository<Commentaire, Integer> {
    
    List<Commentaire> findByUsername(String username);
    
    
  @Transactional
  @Modifying
  @Query(value="delete from Commentaire c where c.idcom = ?1")
  void deleteById(Integer idcom );
    
}
