
package com.app.binouz.model;



public class BeanUtilisateur {
    
    /*
    Création des variables qui vont definir notre utilisateur
    */
    private String pseudo;
    private String nom;
    private String prenom;
    private String motPasse;
    private String adresseMail;
    
    
    /*
    Invocation des Getters & Setters
    */
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }
    
    
    
}