
package com.app.binouz.service;

import com.app.binouz.dao.UserRepository;
import com.app.binouz.model.AppUser;
import com.app.binouz.model.UserRole;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * Implementation de la methode login et authentification avec Spring Security
 * Implementation de l'interface:
 * org.springframework.security.core.userdetails.UserDetailsService 
 * 
 * @author Delomez Matthieu
 */
@Service("UserDetailsService")
public class UserDetailsServiceImpl  implements UserDetailsService {
    
    /*
    Injection du repository relatif à l'utilisateur
    */
    @Autowired
    private UserRepository userRepository;
    
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        AppUser user = userRepository.findByUsername(username);
        
        if (user == null) throw new UsernameNotFoundException(username);
        
        
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (UserRole role : user.getRoles()) {
            
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
                
                return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
                
               


    }
    
    
}
