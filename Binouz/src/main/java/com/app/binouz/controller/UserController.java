package com.app.binouz.controller;

import com.app.binouz.model.AppUser;
import com.app.binouz.security.SecurityService;
import com.app.binouz.service.UserService;
import com.app.binouz.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


/*
* Classe controller qui va gérer les méthodes relatives aux Utilisateurs
* Nottament l'enregistrement des users
*
* @Author: Matthieu Delomez
*/
@Controller
public class UserController {
    
    private static final Logger logger = LogManager.getLogger(UserController.class);

    /*
    Injection de l'interface UserService
     */
    @Autowired
    private UserService userService;

    /*
    Injection de l'interface SecurityService
     */
    @Autowired
    private SecurityService securityService;

    /*
    Injection de la classe UserValidator
     */
    @Autowired
    private UserValidator userValidator;

    /**
     * Méthode Get qui va nous renvoyer le formulaire d'identification
     *
     * @param model - Le Model
     * @return - Retourne la page d'enregistrement
     */
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("appuser", new AppUser());

        return "registration";
    }

    /**
     * Méthode Post qui va configurer les paramètres d'enregistrement d'un
     * nouvel utilisateur en faisant appel à la classe validator ainsi qu'à la
     * méthode save
     *
     * @param appUser - Utilisateur
     * @param bindingResult - BindingResult
     * @param role - Role User
     * @return - Retourne la page registration si success retourne l'index
     */
    @PostMapping("/registration")
    public String registration(@ModelAttribute("appuser") AppUser appUser, BindingResult bindingResult, String role) {

        userValidator.validate(appUser, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(appUser);
        securityService.autoLogin(appUser.getUsername(), appUser.getPassword());
        
        return "/index";

    }

}
