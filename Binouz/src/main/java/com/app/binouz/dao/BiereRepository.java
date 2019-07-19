
package com.app.binouz.dao;

import com.app.binouz.model.Biere;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface BiereRepository extends CrudRepository<Biere, Integer>{
    
    
  // Methode Query qui va nous permettre de rechercher une biere 
 // en fonction de son nom
  @Query("SELECT e FROM Biere e WHERE e.nombiere LIKE %?1")
  public  List<Biere> findByNombiere(String nombiere);
        
  
  // Supression d'une biere en fonction de son nom 
  @Transactional
  @Modifying
  @Query(value="delete from Biere c where c.nombiere = ?1")
  void deleteByNombiere(String nombiere );
  
        
        
    
}
