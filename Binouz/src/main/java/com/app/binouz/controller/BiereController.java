
package com.app.binouz.controller;

import com.app.binouz.dao.BiereRepository;
import com.app.binouz.model.Biere;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class BiereController {
    
    @Autowired
    private  BiereRepository biereRepository;

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
    

    
    
    @GetMapping("searchBiere")
        public String bierehome( Model model, String nombiere) {
            
       
         List <Biere> listTest = biereRepository.findByNombiere(nombiere);
         model.addAttribute("nombieres", biereRepository.findByNombiere(nombiere));
            
         System.out.println("========================>" + listTest.size() + "<==========================");
         System.out.println("=======================>" +nombiere + "<=============================");
            
            return "searchBiere";
                                
        }
        
        
    
    

    
    
    /*
    ************************************************************
    PARTIE RESERVE A LA MODERATION DE APPLICATION
    ************************************************************
    */
    @GetMapping("/deleteBiere")
    public String deleteBiereGet(@Valid Biere biere, BindingResult result,Model model, String nombiere){
        

        biereRepository.deleteByNombiere(nombiere);
        
        System.out.println("=======================>" +nombiere + "<=============================");
        
        
        return "deleteBiere";
        
        

        
    }
  
    
    }
    

