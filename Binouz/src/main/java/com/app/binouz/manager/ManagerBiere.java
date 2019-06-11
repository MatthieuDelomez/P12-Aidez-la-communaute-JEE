
package com.app.binouz.manager;

import com.app.binouz.model.Biere;
import java.util.List;


/*
Creation de l'interface qui servira à implémenter les méthodes: Ajouter | Recuperer | Supp | MAJ une biere
*/
public interface ManagerBiere {
    
    /*
    Création des méthodes qui vont gérer les bieres
    */
    void addBiere(Biere biere);
    
    Biere getBiere(Biere biere);
    
    void deleteBiere(Biere biere);
    
    void updateBiere(Biere biere);
    
    List<Biere> getAllBiere();
    
}
