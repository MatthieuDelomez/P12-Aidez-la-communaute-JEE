
package com.app.binouz.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Bar implements Serializable {
    
    /*
    Création des variables qui vont definir le Bar
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

    
    

    public Bar( String nom, String adresse, String postal, String ville, String description) {
        this.nom = nom;
        this.adresse = adresse;
        this.postal = postal;
        this.ville = ville;
        this.description = description;
    }

    public Bar() {
        super();
    }


     /*
    Invocation des Getters & Setters
    */
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

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
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


    
    
}
