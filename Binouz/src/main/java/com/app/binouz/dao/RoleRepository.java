
package com.app.binouz.dao;

import com.app.binouz.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface RoleRepository extends JpaRepository<UserRole, Long>{
    
    UserRole findByRole(String role);
    
    
    
}
