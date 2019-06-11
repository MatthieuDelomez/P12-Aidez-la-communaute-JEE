
package com.app.binouz.model;


public class Biere {
    
    /*
    Création des variables qui regroupe la biere
    */
    private int idBiere;
    private String nom;
    private String variete;
    private String region;
    private float degres;

    /*
    Constructeur
    */
    public Biere(int idBiere, String nom, String variete, String region, float degres) {
        this.idBiere = idBiere;
        this.nom = nom;
        this.variete = variete;
        this.region = region;
        this.degres = degres;
    }
    
    
    
    
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

    @Override
    public String toString() {
        return "Biere{" + "idBiere=" + idBiere + ", nom=" + nom + ", variete=" + variete + ", region=" + region + ", degres=" + degres + '}';
    }
    
    
    
    
}
