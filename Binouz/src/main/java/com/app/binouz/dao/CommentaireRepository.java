
package com.app.binouz.dao;

import com.app.binouz.model.Commentaire;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {
    
    
    // Generer une liste de commentaires
    List<Commentaire> findByUsername(String username);
    
  
    
   // Supression du commentaire grace à son Id 
  @Transactional
  @Modifying
  @Query(value="delete from Commentaire c where c.idcom = ?1")
  void deleteById(Long idcom );
    
}
