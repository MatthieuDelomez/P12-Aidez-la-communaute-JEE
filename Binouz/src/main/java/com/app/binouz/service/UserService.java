
package com.app.binouz.service;

import com.app.binouz.model.AppUser;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    
    void save(AppUser user);
    
    AppUser findByUsername(String username);
    
}
