
package com.app.binouz.controller;

import com.app.binouz.dao.BiereRepository;
import com.app.binouz.model.Biere;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
    
}
