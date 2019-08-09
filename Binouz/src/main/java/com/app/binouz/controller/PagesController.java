package com.app.binouz.controller;

import com.app.binouz.model.AppUser;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/*
* Classe controller qui va gérer les méthodes relatives aux differentes pages
*
* @Author: Matthieu Delomez
*/
@Controller
public class PagesController {

    /**
     * Méthode Get qui va retourner la page index dans la vue
     *
     * @return - Page index
     */
    @GetMapping("/index")
    public String home() {
        return "index";
    }

    /**
     * Méthode Get qui va retourner la page login dans la vue
     *
     * @param model - Le Model
     * @return - Retourne la page login
     */
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("appuser", new AppUser());
        return "/login";
    }

    /**
     * Méthode Post qui va permettre d'envoyer la reqête d'authentification
     *
     * @param appUser - Utilisateur 
     * @return - Retourne l'index si succes
     */
    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute AppUser appUser) {
        return "/index";
    }
}
