
package com.app.binouz.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Biere implements Serializable {
    
    /*
    Création des variables qui regroupe la biere
    */
    @Id
    @Column(name = "idbiere")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idbiere;
    
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

    /*
    Constructeur
    */
    public Biere(String nombiere, String nombar, String variete, String region, float degres) {
        super();
        this.nombiere = nombiere;
        this.nombar = nombar;
        this.variete = variete;
        this.region = region;
        this.degres = degres;
    }
  
    

    
    /*
    Constructeur par default pour JSon
    */
    public Biere() {
        super();
    }
    

    
    /*
    Invocation des Getters & Setters
    */
    public int getIdbiere() {
        return idbiere;
    }

    public void setIdbiere(int idbiere) {
        this.idbiere = idbiere;
    }

    public String getNombiere() {
        return nombiere;
    }

    public void setNombiere(String nombiere) {
        this.nombiere = nombiere;
    }

    public String getNombar() {
        return nombar;
    }

    public void setNombar(String nombar) {
        this.nombar = nombar;
    }

    public String getVariete() {
        return variete;
    }

    public void setVariete(String variete) {
        this.variete = variete;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public float getDegres() {
        return degres;
    }

    public void setDegres(float degres) {
        this.degres = degres;
    }
    
   
    
    
    
}
