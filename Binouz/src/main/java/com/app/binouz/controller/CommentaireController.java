
package com.app.binouz.controller;

import com.app.binouz.dao.CommentaireRepository;
import com.app.binouz.dao.RoleRepository;
import com.app.binouz.model.AppUser;
import com.app.binouz.model.Commentaire;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


/*
Classe controller qui va gérer les méthodes relatives aux Commentaires
*
@Author: Matthieu Delomez
*/
@Controller
public class CommentaireController {
    
    
    private final CommentaireRepository commentaireRepository;
    
    private RoleRepository roleRepository;

    @Autowired
    public CommentaireController(CommentaireRepository commentaireRepository) {
        this.commentaireRepository = commentaireRepository;
    }



    
    @GetMapping("/addCommentaire")
    public String addCommentaireGet(Model model){
        model.addAttribute("commentaire", new Commentaire());
        
        
        return "addCommentaire";
        
    }
    

    @PostMapping("addCommentaire")
    public String addBiere(@Valid Commentaire commentaire, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addCommentaire";
                   
        }

        commentaireRepository.save(commentaire);
        return "/index";
    }
    
    
    @GetMapping("listCom")
    public String showUpdateForm(Model model) {
        model.addAttribute("commentaires", commentaireRepository.findAll());
        return "listCom";
    }
    
    
    
    
    
        /*
    ************************************************************
    PARTIE RESERVE A LA MODERATION DE APPLICATION
    ************************************************************
    */
    @GetMapping("/deleteCom")
    @Secured("ROLE_ADMIN")
    public String deleteCommentaireGet(Model model, AppUser user){
        model.addAttribute("commentaire", new Commentaire());
        
        
        return "deleteCom";
        
    }
    
    
    
    
    @PostMapping("/deleteCom")
    public String deleteBiereGet(@Valid Commentaire commentaire, BindingResult result,Model model, Integer idcom){
        

        
        commentaireRepository.deleteById(idcom);
        
        System.out.println("=======================>" +idcom + "<=============================");
        
        
        return "index";
        
        

        
    }
    
    
}
