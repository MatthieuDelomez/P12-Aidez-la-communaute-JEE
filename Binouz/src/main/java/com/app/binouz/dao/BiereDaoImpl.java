
package com.app.binouz.dao;

import com.app.binouz.model.Biere;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class BiereDaoImpl implements BiereDao{
    
    public static List<Biere> biere = new ArrayList<>();
    
    static {
        biere.add(new Biere (1, new String("Triple Secrets des Moines"), 
                                                                    new String("Blonde"),
                                                                    new String("Belgique"), (float) 8.5));
        
        biere.add(new Biere (2, new String("Moinettes"), 
                                                                    new String("Blonde"),
                                                                    new String("Belgique"), (float) 8.5));
        
        biere.add(new Biere (3, new String("Lupulus"), 
                                                                    new String("Blonde"),
                                                                    new String("Belgique"), (float) 9.0));
    }

    @Override
    public List<Biere> findAll() {
        return biere;
    }

    @Override
    public Biere findById(int idBiere) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Biere save(Biere biere) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
