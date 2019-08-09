package com.app.binouz.controller;

import com.app.binouz.dao.CommentaireRepository;
import com.app.binouz.model.AppUser;
import com.app.binouz.model.Commentaire;

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
* Classe controller qui va gérer les méthodes relatives aux Commentaires
*
* @Author: Matthieu Delomez
*/
@Controller
public class CommentaireController {

    private final CommentaireRepository commentaireRepository;
    
     private static final Logger logger = LogManager.getLogger(CommentaireController.class);


    /**
     * Injection du Repository relatif aux commentaires
     *
     * @param commentaireRepository - Jpa Repository
     */
    @Autowired
    public CommentaireController(CommentaireRepository commentaireRepository) {
        this.commentaireRepository = commentaireRepository;
    }

    /**
     * Méthode Get qui va nous permettre d'afficher le formulaire de l'ajout du
     * commentaire dans la vue
     *
     * @param model - Le Model
     * @return - Retourne la page pour ajouter un commentaire
     */
    @GetMapping("/addCommentaire")
    public String addCommentaireGet(Model model) {
        model.addAttribute("commentaire", new Commentaire());

        return "addCommentaire";

    }

    /**
     * Méthode Post qui va servir à ajouter un commentaire en base de données
     *
     * @param commentaire - Ajout d'un commentaire
     * @param result - BindingResult
     * @param model - Le Model
     * @return - Retourne la même page si erreur sinon l'index en success 
     */
    @PostMapping("addCommentaire")
    public String addBiere(@Valid Commentaire commentaire, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addCommentaire";

        }

        commentaireRepository.save(commentaire);
        return "/index";
    }

    /**
     * Méthode Get pour afficher dans la vue la liste des commentaires postés
     * par les utilisateurs
     *
     * @param model - Le Model
     * @param page - 4 commentaires par page
     * @return - Retourne la liste des commentaires
     */
    @GetMapping("listCom")
    public String showCom(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("com", commentaireRepository.findAll(new PageRequest(page, 4)));

        model.addAttribute("currentPage", page);

        return "listCom";
    }

    /*
    ************************************************************
    PARTIE RESERVE A LA MODERATION DE APPLICATION
    ************************************************************
     */
    /**
     * Configuration de la page qui servira à la modération des commentaires via
     * le paramètre @Secured seul l'administrateur sera en mesure d'y accèder
     *
     * @param model - Le Model
     * @param user - Role admin pour user sinon accès refusé
     * @return - Retourne la page de suppression des commentaires
     */
    @GetMapping("/deleteCom")
    @Secured("ROLE_ADMIN")
    public String deleteCommentaireGet(Model model, AppUser user) {
        model.addAttribute("commentaire", new Commentaire());

        return "deleteCom";

    }

    /**
     * Configuration de la méthode de modération pour supprimer un commentaire
     * via son Id
     *
     * @param commentaire - Suppression du commentaire
     * @param result - BindingResult
     * @param model - Le Model
     * @param idcom - Supression en fonction de l'Id
     * @return - Retourne l'index si succes
     */
    @PostMapping("/deleteCom")
    public String deleteBiereGet(@Valid Commentaire commentaire, BindingResult result, Model model, Long idcom) {

        commentaireRepository.deleteById(idcom);

        logger.debug("Hello from Log4j 2 - id du commentaire supprimé : {}", idcom);

        return "index";

    }

}
