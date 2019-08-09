package com.app.binouz.controller;

import com.app.binouz.dao.BiereRepository;
import com.app.binouz.model.AppUser;
import com.app.binouz.model.Biere;

import java.util.List;
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

/*
Classe controller qui va gérer les méthodes relatives aux Bieres
*
* @Author: Matthieu Delomez
 */
@Controller
public class BiereController {
    
    private static final Logger logger = LogManager.getLogger(BiereController.class);

    @Autowired
    private BiereRepository biereRepository;

    /**
     * Injection du repository relatif aux bières
     *
     * @param biereRepository - Jpa Repository
     */
    @Autowired
    public BiereController(BiereRepository biereRepository) {
        this.biereRepository = biereRepository;
    }

    /**
     * Méthode GetMapping qui va permettre l'affichage du formulaire
     *
     * @param model - Le Model
     * @return - Retourne addBiere
     */
    @GetMapping("/addBiere")
    public String addBiereGet(Model model) {
        model.addAttribute("biere", new Biere());

        return "addBiere";

    }

    /**
     * Ajout de la méthode Post pour permettre via la méthode save de
     * la classe biereRepository d'ajouter une bière en base de données
     *
     * @param biere - Valid Biere
     * @param result - BindingResult
     * @param model - Le Model
     * @return - addBiere si error sinon retourne l'index en success
     */
    @PostMapping("addBiere")
    public String addBiere(@Valid Biere biere, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addBiere";
        }

        biereRepository.save(biere);
        return "/index";
    }

    /**
     * Méthode Get qui va nous permettre d'afficher la liste des bières
     * référencées
     *
     * @param model - Le Model
     * @param page - Nombre de Biere par page
     * @return - Retourne la liste des bières
     */
    @GetMapping("listBiere")
    public String showPage(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("data", biereRepository.findAll(new PageRequest(page, 4)));

        model.addAttribute("currentPage", page);

        return "listBiere";
    }

    /**
     * Méthode relative à l'affichage des bières présentes en base de données
     *
     * @param model - Le Model
     * @param nombiere - Recherche en fonction du nom de la bière
     * @return - Retourne la page de recherche avec resultat
     */
    @GetMapping("searchBiere")
    public String bierehome(Model model, String nombiere) {

        List<Biere> listTest = biereRepository.findByNombiere(nombiere);
        model.addAttribute("nombieres", biereRepository.findByNombiere(nombiere));
        
        
        logger.debug("Hello from Log4j 2 - nom des bieres : {}", nombiere);
        logger.debug("Hello from Log4j 2 - liste des bieres : {}", listTest.size());

        return "searchBiere";

    }

    /*
    ************************************************************
    PARTIE RESERVE A LA MODERATION DE APPLICATION
    ************************************************************
     */
    /**
     * Configuration de la page qui servira à la modération des bières via le
     * paramètre @Secured seul l'administrateur sera en mesure d'y accèder
     *
     * @param model - Le Model
     * @param user - Role admin pour user
     * @return - Retourne la page de suppression des bières
     */
    @GetMapping("/deleteBiere")
    @Secured("ROLE_ADMIN")
    public String deleteBiereGet(Model model, AppUser user) {
        model.addAttribute("biere", new Biere());

        return "deleteBiere";

    }

    /**
     * Configuration de la méthode qui va nous servir à supprimer une bière en
     * fonction de son Id
     *
     * @param biere - Requête de supression
     * @param result - BindingResult
     * @param model - Le Model
     * @param idbiere - Supression en fonction de l'Id 
     * @return - Retourne l'index en cas de success
     */
    @PostMapping("/deleteBiere")
    public String deleteBiereGeet(@Valid Biere biere, BindingResult result, Model model, Long idbiere) {

        biereRepository.deleteById(idbiere);

        logger.debug("Hello from Log4j 2 - id de la biere supprimé : {}", idbiere);

        return "index";

    }

}
