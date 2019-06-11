
package com.app.binouz.dao;

import com.app.binouz.model.Biere;
import java.util.List;


public interface BiereDao {
    
    public List<Biere> findAll();
    
    public Biere findById(int idBiere);
    
    public Biere save(Biere biere);
    
}
