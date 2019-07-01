
package com.app.binouz.controller;

import com.app.binouz.dao.UserRepository;
import com.app.binouz.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



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
    /*
    @GetMapping("/user")
    public String user() {
        return "/user";
    }*/
    
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
    
    /*
    @GetMapping("/addUser")
    public String addUser(Model model) {
      model.addAttribute("appuser" , new AppUser());
        return "/addUser";
    }
    
    @PostMapping("/addUser")
    public String addUserSubmit(@ModelAttribute AppUser appUser) {
        return "/index";
    }
    
    
    */
    

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
    
    
    
    
    
    
    
}
