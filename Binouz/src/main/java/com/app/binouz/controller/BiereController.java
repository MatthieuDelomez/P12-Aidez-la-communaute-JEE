
package com.app.binouz.controller;

import com.app.binouz.dao.BiereRepository;
import com.app.binouz.model.Biere;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class BiereController {
    
    
    private final BiereRepository biereRepository;

    @Autowired
    public BiereController(BiereRepository biereRepository) {
        this.biereRepository = biereRepository;
    }



    
    @GetMapping("/addBiere")
    public String addBiereGet(Model model){
        model.addAttribute("biere", new Biere());
        
        
        return "addBiere";
        
    }
    

    @PostMapping("addBiere")
    public String addBiere(@Valid Biere biere, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addBiere";
        }

        biereRepository.save(biere);
        return "/index";
    }
    
    
    
    @GetMapping("listBiere")
    public String showUpdateForm(Model model) {
        model.addAttribute("bieres", biereRepository.findAll());
        return "listBiere";
    }
    
    
    /*
    ************************************************************
    PARTIE RESERVE A LA MODERATION DE APPLICATION
    ************************************************************
    */
    
    @GetMapping("/deleteBiere")
    public String deleteBiereGet(Model model){
        model.addAttribute("biere", new Biere());
        
        
        return "deleteBiere";
        
    }
    /*
    @PostMapping("delete/{idbiere}")
    public String deleteBiere(@PathVariable("idbiere") int idbiere, @Valid Biere biere, BindingResult result,
        Model model) {
        if (result.hasErrors()) {
            biere.setIdbiere(idbiere);
            return "delete-biere";
        }

        biereRepository.delete(biere);
        model.addAttribute("bieres", biereRepository.findAll());
        return "index";
    }*/
    
    //**********************************************************//
    
    /*

    @PostMapping("/deleteBiere")        
        public String deleteBiere(@Valid Biere biere, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "deleteBiere";
        }

        biereRepository.delete(biere);
        return "/index";
    }*/
        
        /*
         @GetMapping("delete/{idbiere}")
    public String deleteStudent(@PathVariable("idbiere") int idbiere, Model model) {
        Biere biere =  biereRepository.findById(idbiere)
                
                
           .orElseThrow(() - > new IllegalArgumentException("Invalid student Id:" + idbiere));
        
        
        biereRepository.delete(biere);
        model.addAttribute("bieres", biereRepository.findAll());
        return "index";
    }*/
    
    }
    

