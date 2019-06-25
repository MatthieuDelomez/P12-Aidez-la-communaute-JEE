
package com.app.binouz.dao;

import com.app.binouz.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;





public interface RoleRepository extends JpaRepository<UserRole, Long>{

    
}
