
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
    
        @Query("SELECT e FROM Biere e WHERE e.nombiere LIKE %?1")
        public  List<Biere> findByNombiere(String nombiere);
        
        
  @Transactional
  @Modifying
  @Query(value="delete from Biere c where c.nombiere = ?1")
  void deleteByNombiere(String nombiere );
  
        
        
    
}
