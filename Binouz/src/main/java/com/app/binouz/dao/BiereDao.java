
package com.app.binouz.dao;

import com.app.binouz.model.Biere;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BiereDao extends JpaRepository<Biere, Integer>{
   /* 
    public List<Biere> findAll();
    
    public Biere findById(int idBiere);
    
    public Biere save(Biere biere);
*/
    
    Biere findById(int idBiere);
    
    /*
    Méthode qui va nous permettre de recupérer une liste de bière en fonction
    de sa région ==> Méthode qui sera daptée pour récupérer en fonction du bar / région / nom
    */
   // List<Biere>  findByRegionForBeer(String region);
    
    @Query("SELECT idbiere, nom, variete, region, degres FROM Biere p WHERE p.region > :region ")
    List<Biere> chercherUneBiereForte(@Param("region") String region);
    
    
}
