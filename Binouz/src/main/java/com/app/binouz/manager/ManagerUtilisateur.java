
package com.app.binouz.manager;

import com.app.binouz.model.Utilisateur;
import java.util.List;

/*
Creation de l'interface qui servira à implémenter les méthodes: Ajouter | Recuperer | Supp | MAJ un utilisateur
*/
public interface ManagerUtilisateur {
    
     /*
    Création des méthodes qui vont gérer les bieres
    */
    void addUtilisateur(Utilisateur utilisateur);
    
    Utilisateur getUtilisateur(Utilisateur utilisateur);
    
    void deleteUtilisateur(Utilisateur utilisateur);
    
    void updateUtilisateur(Utilisateur utilisateur);
    
    List<Utilisateur> getAllUtilisateur();
    
}
