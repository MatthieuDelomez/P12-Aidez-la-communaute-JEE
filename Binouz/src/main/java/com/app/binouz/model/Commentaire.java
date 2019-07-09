
package com.app.binouz.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Commentaire implements Serializable {
    
    /*
    Création des variable qui vot definir les commentaires
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcom")
    private int idCom;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "titre")
    private String titre;
    
    @Column(name = "nombar")
    private String nombar;
    
    @Column(name = "description")
    private String description;

    /*
    Invocation des Getters & Setters
    */
    public int getIdCom() {
        return idCom;
    }

    public void setIdCom(int idCom) {
        this.idCom = idCom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNombar() {
        return nombar;
    }

    public void setNombar(String nombar) {
        this.nombar = nombar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
   
    
  
    
    
}
