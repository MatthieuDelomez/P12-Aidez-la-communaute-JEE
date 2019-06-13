
package com.app.binouz.model;


public class Commentaire {
    
    /*
    Création des variable qui vot definir les commentaires
    */
    private int idCom;
    private Long userId;
    private String titre;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
  
    
    
}
