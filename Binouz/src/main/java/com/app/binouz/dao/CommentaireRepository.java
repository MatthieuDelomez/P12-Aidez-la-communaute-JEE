
package com.app.binouz.dao;

import com.app.binouz.model.Commentaire;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CommentaireRepository extends CrudRepository<Commentaire, Integer> {
    
    List<Commentaire> findByUsername(String username);
    
}
