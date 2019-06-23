
package com.app.binouz.service;

import com.app.binouz.dao.UserRepository;
import com.app.binouz.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class UserService {
    
    /*
    
    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping(value = "/saveUser", method = RequestMethod.GET)
    public AppUser saveUser(AppUser e) {
        return userRepository.save(e);
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Page<AppUser> listUsers (int page, int size) {
        
        return userRepository.findAll(new PageRequest(page, size));
    }
    */
    
    
}
