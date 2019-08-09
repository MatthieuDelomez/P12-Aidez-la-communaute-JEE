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
 * notre table Bière
 *
 * @author Matthieu Delomez
 */
@Entity
public class Biere implements Serializable {

    /*
   * Création des variables qui font références aux colonnes 
   * présentes en base
   * 
   * @Id: Définition de la clé primaire
   * @GeneratedValue: Définir notre Id en AutoIncrement
   * @Column: Configuration des colonnes présentes en base
     */
    @Id
    @Column(name = "idbiere")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idbiere;

    @Column(name = "nombiere")
    private String nombiere;

    @Column(name = "nombar")
    private String nombar;

    @Column(name = "variete")
    private String variete;

    @Column(name = "region")
    private String region;

    @Column(name = "degres")
    private float degres;

    /**
     * Constructeur avec des paramètres
     *
     * @param nombiere - nom de la bière
     * @param nombar - nom du bar
     * @param variete - variete de biere
     * @param region - region de la biere
     * @param degres - degres de la biere
     */
    public Biere(String nombiere, String nombar, String variete, String region, float degres) {
        super();
        this.nombiere = nombiere;
        this.nombar = nombar;
        this.variete = variete;
        this.region = region;
        this.degres = degres;
    }

    /**
     * Constructeur sans paramètre
     *
     */
    public Biere() {
        super();
    }
    
    

    /*
    ************************************************************
                  INVOCATION DES GETTES & SETTERS
    ************************************************************
     */
    /**
     *
     * @return idbiere
     */
    public Long getIdbiere() {
        return idbiere;
    }

    /**
     *
     * @param idbiere - Id de la bière
     */
    public void setIdbiere(Long idbiere) {
        this.idbiere = idbiere;
    }

    /**
     *
     * @return nombiere
     */
    public String getNombiere() {
        return nombiere;
    }

    /**
     *
     * @param nombiere - Nom de la bière
     */
    public void setNombiere(String nombiere) {
        this.nombiere = nombiere;
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
     * @param nombar - Nom du bar
     */
    public void setNombar(String nombar) {
        this.nombar = nombar;
    }

    /**
     *
     * @return variete
     */
    public String getVariete() {
        return variete;
    }

    /**
     *
     * @param variete - Variete de la biere
     */
    public void setVariete(String variete) {
        this.variete = variete;
    }

    /**
     *
     * @return region
     */
    public String getRegion() {
        return region;
    }

    /**
     *
     * @param region - Région de la biere
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     *
     * @return degres
     */
    public float getDegres() {
        return degres;
    }

    /**
     *
     * @param degres - Degres de la biere
     */
    public void setDegres(float degres) {
        this.degres = degres;
    }

}
