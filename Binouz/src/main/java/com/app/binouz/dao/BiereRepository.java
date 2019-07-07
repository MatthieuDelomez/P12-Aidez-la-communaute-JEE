
package com.app.binouz.dao;

import com.app.binouz.model.Biere;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface BiereRepository extends CrudRepository<Biere, Integer>{
    
    List<Biere> findByNombiere(String nombiere);
    
}
