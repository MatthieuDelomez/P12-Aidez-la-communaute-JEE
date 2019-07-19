
package com.app.binouz.dao;

import com.app.binouz.model.UserRole;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface RoleRepository extends JpaRepository<UserRole, Long>{
    
    // Methode qui va nous permettre de definir le role lors de l'enregistrement du User Lambda
     public  List<UserRole>  findByRole(String role);
    
    
    
    
    
    
    
}
