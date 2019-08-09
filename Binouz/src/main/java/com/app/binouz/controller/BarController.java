package com.app.binouz.controller;

import com.app.binouz.dao.BarRepository;
import com.app.binouz.model.Bar;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Classe controller qui va gérer les méthodes relatives aux Bars
 *
 * @author Matthieu Delomez
 */
@Controller
public class BarController {
    
    private static final Logger logger = LogManager.getLogger(BarController.class);

    private final BarRepository barRepository;

    /**
     * Injection du Repository relatif aux bars
     *
     * @param barRepository - Jpa Repository
     */
    @Autowired
    public BarController(BarRepository barRepository) {
        this.barRepository = barRepository;
    }

    /**
     * Méthode Get qui va nous servir à afficher la liste des bars quatres bars
     * seront affichés par pages.
     * Page par défault commence à 0
     *
     * @param model 
     *                             Le Model 
     * @param page
     *                          Le nombre de Bar que va contenir la page
     * @return
     *                Retourne la liste du Bar
     */
    @GetMapping("listBar")
    public String showBar(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("barData", barRepository.findAll(new PageRequest(page, 4)));

        model.addAttribute("currentPage", page);

        return "listBar";
    }

    /**
     * Méthode Get pour afficher le formulaire de l'ajout des bars
     *
     * @param model
     *                             Le Model
     * @return
     *                Retourne la page addBar
     */
    @GetMapping("/addBar")
    public String addBarGet(Model model) {
        model.addAttribute("bar", new Bar());

        return "addBar";

    }

    /**
     * Méthode Post qui va paramétrer l'ajout d'un bar en base de données via la
     * méthode save du barRepository
     *
     * @param bar - Bar
     * @param result - Utilisation du BindingResult
     * @param model - Le Model
     * @return - Retroune l'index une fois la méthode terminée
     */
    @PostMapping("addBar")
    public String addBar(@Valid Bar bar, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addBar";
        }

        barRepository.save(bar);
        return "/index";
    }

    /*
    ************************************************************
    PARTIE RESERVE A LA MODERATION DE APPLICATION
    ************************************************************
     */
    /**
     * Configuration de la page qui servira à la modération des bars via le
     * paramètre @Secured seul l'administrateur sera en mesure d'y accèder
     *
     * @param model - Le Model
     * @return - Retourne deleteBar
     */
    @Secured("ROLE_ADMIN")
    @GetMapping("/deleteBar")
    public String deleteBarGet(Model model) {
        model.addAttribute("bar", new Bar());

        return "deleteBar";

    }

    /**
     * Configuration de le méthode qui va nous servir à supprimer un bar en
     * fonction de son id. 
     * Nous ferons appel à la méthode delete présent dans la classe barRepository
     *
     * @param bar - Valid Bar
     * @param result - BindingResult
     * @param model - Le Model
     * @param nom - Suppression via le nom
     * @return - Index
     */
    @PostMapping("/deleteBar")
    public String deleteBiereGet(@Valid Bar bar, BindingResult result, Model model, String nom) {

        barRepository.deleteByNom(nom);
        
        logger.debug("Hello from Log4j 2 - nom du bar supprimé : {}", nom);

        return "index";

    }

}
