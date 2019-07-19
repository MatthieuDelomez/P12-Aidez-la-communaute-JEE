
package com.app.binouz.controller;

import com.app.binouz.model.AppUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



/*
Classe controller qui va gérer les méthodes relatives aux differentes pages
*
@Author: Matthieu Delomez
*/
@Controller
public class PagesController {
    
    @GetMapping("/index")
    public String home() {
        return "index";
    }
    
    
    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    
    @GetMapping("/about")
    public String about() {
        return "/about";
    }
    
    
    
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("appuser" , new AppUser());
        return "/login";
    }
    
    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute AppUser appUser) {
        return "/index";
    }
}
    
   