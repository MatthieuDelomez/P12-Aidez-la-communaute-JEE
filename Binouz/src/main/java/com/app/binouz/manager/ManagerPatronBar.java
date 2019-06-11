
package com.app.binouz.manager;

import com.app.binouz.model.PatronBar;
import java.util.List;


public interface ManagerPatronBar {
    
       /*
    Création des méthodes qui vont gérer les patrons de Bar
    */
    void addPatronBar(PatronBar patronBar);
    
    PatronBar getPatronBar(PatronBar patronBar);
    
    void deletePatronBar(PatronBar patronBar);
    
    void updatePatronBar(PatronBar patronBar);
    
    List<PatronBar> getAllPatronBar();
    
}
