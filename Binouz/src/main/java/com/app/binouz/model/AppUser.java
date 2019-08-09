package com.app.binouz.model;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Création de notre classe entité qui va nous permettre de faire la jonction
 * entre notre base de données et notre classe Java. Classe qui correspond à
 * notre table utilisateur
 *
 * @author Matthieu Delomez
 */
@Entity
@Table(name = "App_User", uniqueConstraints = {
    @UniqueConstraint(name = "APP_USER_UK", columnNames = "username"), 
    @UniqueConstraint(name = "APP_USER_GM", columnNames = "adresse_mail")})
public class AppUser implements Serializable {
    

    /*
   * Création des variables qui font références aux colonnes 
   * présentes en base
   * 
   * @Id: Définition de la clé primaire
   * @Column: Configuration des colonnes présentes en base
     */
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


  /*
   * Méthode correspondante à l'assignation des rôles
   */
    @ManyToMany
    private Set<UserRole> roles;

    /**
     * Constructeur sans paramètre
     * 
     */
    public AppUser() {
        super();
    }

    /**
     * Constructeur avec des paramètres
     *
     * @param username - pseudo
     * @param adresseMail - adresse mail
     * @param password - mot de passe
     * @param nom - nom de l'utilisateur
     * @param prenom - prenom de l'utilisateur
     */
    public AppUser(String username, String adresseMail, String password, String nom, String prenom) {
        this.username = username;
        this.adresseMail = adresseMail;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
    }

    /*
    ************************************************************
                  INVOCATION DES GETTES & SETTERS
    ************************************************************
     */
    /**
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username - Username de l'utilisateur
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return - adresse mail
     */
    public String getAdresseMail() {
        return adresseMail;
    }

    /**
     *
     * @param adresseMail - Adresse mail de l'utilisateur
     */
    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }

    /**
     *
     * @return mot de passe
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password - Mot de passe de l'utilisateur
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom - Nom de l'utilisateur
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return - prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     *
     * @param prenom - Prenom de l'utilisateur
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     *
     * @return roles
     */
    public Set<UserRole> getRoles() {
        return roles;
    }

    /**
     *
     * @param roles - Rôles des utilisateurs
     */
    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

}
