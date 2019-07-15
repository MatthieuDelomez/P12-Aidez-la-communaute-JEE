
package com.app.binouz.dao;

import com.app.binouz.model.AppUser;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<AppUser, String>{
    
    
    AppUser findByUsername(String username);
    

    
}
