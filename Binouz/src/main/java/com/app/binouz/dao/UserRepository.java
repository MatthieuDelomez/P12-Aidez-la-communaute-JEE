
package com.app.binouz.dao;

import com.app.binouz.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<AppUser, String>{
    
}
