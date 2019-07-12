
package com.app.binouz.dao;

import com.app.binouz.model.Biere;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BiereRepository extends CrudRepository<Biere, Integer>{
    
        @Query("SELECT e FROM Biere e WHERE e.nombiere LIKE %?1")
        public  List<Biere> findByNombiere(String nombiere);
        
        
    
}
