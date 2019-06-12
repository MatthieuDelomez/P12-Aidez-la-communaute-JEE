
package com.app.binouz.controller;

import com.app.binouz.dao.BiereDao;
import com.app.binouz.model.Biere;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class BiereController {
    
    
    @Autowired
    private BiereDao biereDao;
    
    //Biere
    @GetMapping(value = "Biere")
    public List<Biere> listeBiere() {
        return biereDao.findAll();
    }
    
    //Biere/{idBiere}
    @GetMapping(value = "Biere/{idbiere}")
    public Biere afficherUneBiere(@PathVariable int idbiere) {
        
        /*
        Effectuer la méthode qui va retourner la biere en fonction de le ID
        Nous appellons donc le Dao pour le moment
        */
        return biereDao.findById(idbiere);
        
    }
    
    @PostMapping(value = "/Biere")
    public ResponseEntity<Void>  ajouterBiere(@RequestBody Biere biere){
        
       Biere biere1 =  biereDao.save(biere);
       
       if(biere == null) {
           return ResponseEntity.noContent().build();
       }
       
       /*
       Méthode pour générer la le bon code dans Postman
       */
       URI location = ServletUriComponentsBuilder
                                 .fromCurrentRequest()
                                 .path("/{idbiere}")
                                 .buildAndExpand(biere1.getIdBiere())
                                 .toUri();
       
       return ResponseEntity.created(location).build();
        
    }
    
    
    @GetMapping(value = "test/Biere/{region}")
    public List<Biere> testRequetePourRegion(@PathVariable String region){
        return biereDao.chercherUneBiereForte("Belgique");
    }
    
}
