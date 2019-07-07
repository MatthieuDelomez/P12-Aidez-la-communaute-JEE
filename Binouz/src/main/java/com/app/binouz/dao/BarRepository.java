
package com.app.binouz.dao;

import com.app.binouz.model.Bar;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BarRepository extends CrudRepository<Bar, Integer>{
    
    List<Bar> findByNom(String nom);
    
}
