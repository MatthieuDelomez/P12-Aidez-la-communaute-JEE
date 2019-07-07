
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
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class BarController {
    
    
    
    private final BarRepository barRepository;

    @Autowired
    public BarController(BarRepository barRepository) {
        this.barRepository = barRepository;
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

   
/*
    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id, Model model) {
        Student student = studentRepository.findById(id)
            .orElseThrow(() - > new IllegalArgumentException("Invalid student Id:" + id));
        studentRepository.delete(student);
        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }
*/
}
