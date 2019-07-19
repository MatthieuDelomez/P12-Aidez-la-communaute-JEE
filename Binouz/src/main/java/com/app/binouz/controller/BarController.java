
package com.app.binouz.controller;

import com.app.binouz.dao.BarRepository;
import com.app.binouz.model.Bar;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


/*
Classe controller qui va gérer les méthodes relatives aux Bars
*
@Author: Matthieu Delomez
*/
@Controller
public class BarController {
    
    
    
    private final BarRepository barRepository;

    @Autowired
    public BarController(BarRepository barRepository) {
        this.barRepository = barRepository;
    }
    
    
    @GetMapping("listBar")
    public String showUpdateForm(Model model) {
        model.addAttribute("bars", barRepository.findAll());
        return "listBar";
    }



    
   

    
    /*
    ************************************************************
    PARTIE RESERVE A LA MODERATION DE APPLICATION
    ************************************************************
    */
    @GetMapping("/deleteBar")
    public String deleteBarGet(Model model){
        model.addAttribute("bar", new Bar());
        
        
        return "deleteBar";
        
    }
    
    
    
    @PostMapping("/deleteBar")
    public String deleteBiereGet(@Valid Bar bar, BindingResult result,Model model, String nom){
        

        barRepository.deleteByNom(nom);
        
        System.out.println("=======================>" +nom + "<=============================");
        
        
        return "index";
        
        
         }

    
    @GetMapping("/addBar")
    public String addBarGet(Model model){
        model.addAttribute("bar", new Bar());
        
        
        return "addBar";
        
    }
    

    @PostMapping("addBar")
    public String addBar(@Valid Bar bar, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addBar";
        }

        barRepository.save(bar);
        return "/index";
    }

}
