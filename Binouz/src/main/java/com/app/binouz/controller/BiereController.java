
package com.app.binouz.controller;

import com.app.binouz.dao.BiereDao;
import com.app.binouz.model.Biere;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


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
    @GetMapping(value = "Biere/{idBiere}")
    public Biere afficherUneBiere(@PathVariable int idBiere) {
        
        /*
        Effectuer la méthode qui va retourner la biere en fonction de le ID
        */
        Biere biere = new Biere(idBiere, new String("Triple Secrets des Moines"), 
                                                                    new String("Blonde"),
                                                                    new String("Belgique"), (float) 8.5);
        
        return biere;
        
    }
    
}
