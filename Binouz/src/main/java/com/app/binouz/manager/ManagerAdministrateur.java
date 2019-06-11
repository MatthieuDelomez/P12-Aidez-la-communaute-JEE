
package com.app.binouz.manager;

import com.app.binouz.model.Administrateur;
import java.util.List;


/*
Creation de l'interface qui servira à implémenter les méthodes: Ajouter | Recuperer | Supp | MAJ un Admin
*/
public interface ManagerAdministrateur {
    
     /*
    Création des méthodes qui vont gérer les administrateur
    */
    void addAdministrateur(Administrateur administrateur);
    
    Administrateur getAdministrateur(Administrateur administrateur);
    
    void deleteAdministrateur(Administrateur administrateur);
    
    void updateAdministrateur(Administrateur administrateur);
    
    List<Administrateur> getAllAdministrateur();
    
}
