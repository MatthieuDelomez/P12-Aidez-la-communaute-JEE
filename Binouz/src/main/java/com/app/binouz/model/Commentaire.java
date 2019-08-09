package com.app.binouz.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Création de notre classe entité qui va nous permettre de faire la jonction
 * entre notre base de données et notre classe Java. Classe qui correspond à
 * notre table Commentaire
 *
 * @author Matthieu Delomez
 */
@Entity
public class Commentaire implements Serializable {


    /*
   * Création des variables qui font références aux colonnes 
   * présentes en base.
   * Création des variables qui vont definir les commentaires
   * 
   * @Id: Définition de la clé primaire
   * @GeneratedValue: Définir notre Id en AutoIncrement
   * @Column: Configuration des colonnes présentes en base
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcom")
    private Long idcom;

    @Column(name = "username")
    private String username;

    @Column(name = "titre")
    private String titre;

    @Column(name = "nombar")
    private String nombar;

    @Column(name = "description")
    private String description;
    
    

    /*
    ************************************************************
                  INVOCATION DES GETTES & SETTERS
    ************************************************************
     */
    /**
     *
     * @return idcom
     */
    public Long getIdcom() {
        return idcom;
    }

    /**
     *
     * @param idcom - Id du commentaire
     */
    public void setIdCom(Long idcom) {
        this.idcom = idcom;
    }

    /**
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username - Pseudo de l'utilisateur ayant posté le commentaire
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     *
     * @param titre - Titre du commentaire
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     *
     * @return nombar
     */
    public String getNombar() {
        return nombar;
    }

    /**
     *
     * @param nombar - Nom du bar commenté
     */
    public void setNombar(String nombar) {
        this.nombar = nombar;
    }

    /**
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description - Corps du commentaire
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
