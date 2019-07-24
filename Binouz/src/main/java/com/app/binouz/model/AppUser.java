
package com.app.binouz.model;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name= "App_User", uniqueConstraints = {
    @UniqueConstraint(name = "APP_USER_UK", columnNames = "username"), 
    @UniqueConstraint(name = "APP_USER_GM", columnNames = "adresse_mail")})
public class AppUser implements Serializable{
    
    

   @Id
   @Column(name = "username", length = 36, nullable = false)
    private String username;
    
   @Column(name = "adresse_mail", length = 120, nullable = false)
    private String adresseMail;
 
   @Column(name = "password", length = 128, nullable = false)
    private String password;
    
    @Column(name = "nom", length = 30, nullable = false)
    private String nom;
    
   @Column(name = "prenom", length = 30, nullable = false)
    private String prenom;
   

   
  @ManyToMany
   private Set<UserRole> roles;
   
   


    public AppUser() {
        super();
    }

    public AppUser(String username, String adresseMail, String password, String nom, String prenom) {
        this.username = username;
        this.adresseMail = adresseMail;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
    }
 

     /*
    Invocation des Getters & Setters
    */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAdresseMail() {
        return adresseMail;
    }

    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }


    
    
    
    



    
    


    


    


         
         
    
    
    
   
   
   
   
    

    
    
    
    
    
    
    
    
    

   


    

    
    
    
}
