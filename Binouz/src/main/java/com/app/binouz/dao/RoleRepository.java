
package com.app.binouz.dao;

import com.app.binouz.model.Biere;
import com.app.binouz.model.UserRole;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;




@Repository
public interface RoleRepository extends JpaRepository<UserRole, Long>{
    
    
   //@Query(value="select c from UserRole c where c.rolename = : role")
     public  List<UserRole>  findByRole(/*@Param("role") */String role);
    
    
    
    
    
    
    
}
