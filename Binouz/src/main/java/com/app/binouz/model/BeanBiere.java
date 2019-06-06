
package com.app.binouz.model;


public class BeanBiere {
    
    /*
    Création des variables qui regroupe la biere
    */
    private int idBiere;
    private String nom;
    private String variete;
    private String region;
    private float degres;
    
    
    /*
    Invocation des Getters & Setters
    */
    public int getIdBiere() {
        return idBiere;
    }

    public void setIdBiere(int idBiere) {
        this.idBiere = idBiere;
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
    
    
}
