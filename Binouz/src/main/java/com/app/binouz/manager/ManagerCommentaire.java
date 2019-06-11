
package com.app.binouz.manager;

import com.app.binouz.model.Commentaire;
import java.util.List;



/*
Creation de l'interface qui servira à implémenter les méthodes: Ajouter | Recuperer | Supp | MAJ une publication
*/
public interface ManagerCommentaire {
    
    /*
    Création des méthodes qui vont gérer les commentaires
    */
    void addCommentaire(Commentaire commentaire);
    
    Commentaire getCommentaire(Commentaire commentaire);
    
    void deleteCommentaire(Commentaire commentaire);
    
    void updateCommentaire(Commentaire commentaire);
    
    List<Commentaire> getAllCommentaire();
    
}
