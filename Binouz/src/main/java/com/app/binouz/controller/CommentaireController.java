
package com.app.binouz.controller;

import com.app.binouz.dao.CommentaireRepository;
import com.app.binouz.model.Commentaire;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class CommentaireController {
    
    
    private final CommentaireRepository commentaireRepository;

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
    public String deleteCommentaireGet(Model model){
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
