
package com.app.binouz.dao;

import com.app.binouz.model.Bar;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface BarRepository extends CrudRepository<Bar, Integer>{
    
    List<Bar> findByNom(String nom);
    
   
  //Methode qui va nous permettre du suprimer un bar en fonction de son nom  
  @Transactional
  @Modifying
  @Query(value="delete from Bar c where c.nom = ?1")
  void deleteByNom(String nom );
    
}
