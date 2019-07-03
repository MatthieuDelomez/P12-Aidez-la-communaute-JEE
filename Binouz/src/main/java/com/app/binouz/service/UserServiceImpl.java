
package com.app.binouz.service;

import com.app.binouz.dao.RoleRepository;
import com.app.binouz.dao.UserRepository;
import com.app.binouz.model.AppUser;
import com.app.binouz.model.UserRole;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import org.springframework.security.crypto.password.PasswordEncoder;




@Service("UserService")
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(AppUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
        
        
    }

    @Override
    public AppUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
   
    
    
    

    

 
    
    
}
