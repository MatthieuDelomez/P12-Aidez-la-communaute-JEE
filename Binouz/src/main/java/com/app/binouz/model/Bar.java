package com.app.binouz.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Création de notre classe entité qui va nous permettre de faire la jonction
 * entre notre base de données et notre classe Java. Classe qui correspond à
 * notre table Bar
 *
 * @author Matthieu Delomez
 */
@Entity
public class Bar implements Serializable {


    /*
   * Création des variables qui font références aux colonnes 
   * présentes en base.
   * Création des variables qui vont definir le Bar
   * 
   * @Id: Définition de la clé primaire
   * @Column: Configuration des colonnes présentes en base
     */
    @Id
    @Column(name = "nom")
    private String nom;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "postal")
    private String postal;

    @Column(name = "ville")
    private String ville;

    @Column(name = "description")
    private String description;

    /**
     * Constructeur avec des paramètres
     *
     * @param nom - nom du bar
     * @param adresse - adresse du bar
     * @param postal - code postal du bar
     * @param ville - ville du bar
     * @param description - description du bar
     */
    public Bar(String nom, String adresse, String postal, String ville, String description) {
        this.nom = nom;
        this.adresse = adresse;
        this.postal = postal;
        this.ville = ville;
        this.description = description;
    }

    /**
     * Constructeur sans paramètre
     *
     */
    public Bar() {
        super();
    }

    
    
    /*
    ************************************************************
                  INVOCATION DES GETTES & SETTERS
    ************************************************************
     */
    /**
     *
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom - Nom du bar
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return adresse
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     *
     * @param adresse - Adresse du bar
     */
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /**
     *
     * @return postal
     */
    public String getPostal() {
        return postal;
    }

    /**
     *
     * @param postal - Code postal du bar
     */
    public void setPostal(String postal) {
        this.postal = postal;
    }

    /**
     *
     * @return ville
     */
    public String getVille() {
        return ville;
    }

    /**
     *
     * @param ville - Ville du bar
     */
    public void setVille(String ville) {
        this.ville = ville;
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
     * @param description - Description du bar
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
