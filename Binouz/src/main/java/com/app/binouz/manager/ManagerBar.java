
package com.app.binouz.manager;

import com.app.binouz.model.Bar;
import java.util.List;


/*
Creation de l'interface qui servira à implémenter les méthodes: Ajouter | Recuperer | Supp | MAJ un bar
*/
public interface ManagerBar {
    
    /*
    Création des méthodes qui vont gérer les bars
    */
    void addBar(Bar bar);
    
    Bar getBar(Bar bar);
    
    void deleteBar(Bar bar);
    
    void updateBar(Bar bar);
    
    List<Bar> getAllBar();
    
}
