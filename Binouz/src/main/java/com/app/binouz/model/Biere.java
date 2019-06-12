
package com.app.binouz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="Biere")
@Entity
public class Biere {
    
    /*
    Création des variables qui regroupe la biere
    */
    @Id
    @GeneratedValue
    @Column(unique = true)
    private int idbiere;
    
    private String nom;
    private String variete;
    private String region;
    private float degres;

    /*
    Constructeur
    */
    public Biere(int idbiere, String nom, String variete, String region, float degres) {
        this.idbiere = idbiere;
        this.nom = nom;
        this.variete = variete;
        this.region = region;
        this.degres = degres;
    }
    
    /*
    Constructeur par default pour JSon
    */
    public Biere() {
    }
    

    
    /*
    Invocation des Getters & Setters
    */
    public int getIdBiere() {
        return idbiere;
    }

    public void setIdBiere(int idbiere) {
        this.idbiere = idbiere;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    @Override
    public String toString() {
        return "Biere{" + "idbiere=" + idbiere + ", nom=" + nom + ", variete=" + variete + ", region=" + region + ", degres=" + degres + '}';
    }
    
    
    
    
}
