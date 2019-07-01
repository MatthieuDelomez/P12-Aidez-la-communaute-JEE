
package com.app.binouz.controller;

import com.app.binouz.model.AppUser;
import com.app.binouz.security.SecurityService;
import com.app.binouz.service.UserService;
import com.app.binouz.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private SecurityService securityService;
    
    @Autowired
    private UserValidator userValidator;
    
    
    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("appuser", new AppUser());
        
        
        return "registration";
        
    }
    
    
    
    @PostMapping("/registration")
    public String registration(@ModelAttribute("appuser") AppUser appUser, BindingResult bindingResult) {
        
        userValidator.validate(appUser, bindingResult);
        
        
        if(bindingResult.hasErrors()) {
            return "registration";
        }
        
        userService.save(appUser);
                securityService.autoLogin(appUser.getUsername(), appUser.getPasswordConfirm());
                
                return "/index";

        
    }
    
}
