
package com.app.binouz.model;


public class BeanBar {
    
    /*
    Création des variables qui vont definir le Bar
    */
    private int idBar;
    private int idBiere;
    
    private String nom;
    private String adresse;
    private String codePostal;
    private String ville;
    private String description;
    private float note;
    
    /*
    Invocation des variables
    */
    public int getIdBar() {
        return idBar;
    }

    public void setIdBar(int idBar) {
        this.idBar = idBar;
    }

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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }
    
    
}
