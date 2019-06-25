
package com.app.binouz.service;

import com.app.binouz.dao.RoleRepository;
import com.app.binouz.dao.UserRepository;
import com.app.binouz.model.AppUser;
import com.app.binouz.model.UserRole;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class UserService {
    
    
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    /*
    
    @RequestMapping(value = "/addUser")
    public AppUser save(AppUser u) {
        return userRepository.save(u);
    }
    
    @RequestMapping(value = "/findUsers")
    public List<AppUser> findAll() {
        return userRepository.findAll();
    }
    
    
    
    @RequestMapping(value = "addRole")
    public UserRole saveRole(UserRole r){
        return roleRepository.save(r);
    }
    
    @RequestMapping(value = "/findRoles")
    public List<UserRole> findRoles() {
        return roleRepository.findAll();
    }
    
    /*
    @RequestMapping(value = "/addRoleToUser")
    public AppUser addRoleToUser(String username, String role) {
        
        AppUser u = userRepository.findOne(username);
        UserRole r = roleRepository.findOne(role);
        u.getRoles().add(r);

        userRepository.save(u);
        return u;
    }
    
    
    
    
    /*
    
    @Secured(value = {"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(value = "/saveUser", method = RequestMethod.GET)
    public AppUser saveUser(AppUser e) {
        return userRepository.save(e);
    }
    
    
    @Secured(value = {"ROLE_ADMIN"})
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Page<AppUser> listUsers (int page, int size) {
        
        return userRepository.findAll(new PageRequest(page, size));
    }
    
    */
    
}
