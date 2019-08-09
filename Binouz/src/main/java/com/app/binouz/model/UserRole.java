package com.app.binouz.model;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Création de notre classe entité qui va nous permettre de faire la jonction
 * entre notre base de données et notre classe Java. Classe qui correspond à
 * notre table de jonction pour définir les rôles de chaque utilisateur
 *
 * @author Matthieu Delomez
 */
@Entity
@Table(name = "utilisateur_roles")
public class UserRole implements Serializable {

    /*
   * Création des variables qui font références aux colonnes 
   * présentes en base.
   * Création des variables qui vont definir les nos rôles
   * 
   * @Id: Définition de la clé primaire
   * @GeneratedValue: Définir notre Id en AutoIncrement
   * @Column: Configuration des colonnes présentes en base
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userroleid", nullable = false)
    private int userRoleId;

    @Column(name = "rolename", length = 45, nullable = false)
    private String role;

    @ManyToMany
    @JoinTable(name = "app_user_roles", joinColumns = @JoinColumn(name = "roles_userroleid"), inverseJoinColumns = @JoinColumn(name = "app_user_username"))
    private Set<AppUser> users;
    
    

    /*
    ************************************************************
                  INVOCATION DES GETTES & SETTERS
    ************************************************************
     */
    /**
     *
     * @return userRoleId
     */
    public int getUserRoleId() {
        return userRoleId;
    }

    /**
     *
     * @param userRoleId - Id du rôle utilisateur
     */
    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    /**
     *
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     *
     * @param role - Role défini pour l'utilisateur
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     *
     * @return users
     */
    public Set<AppUser> getUsers() {
        return users;
    }

    /**
     *
     * @param users - Utilisateur
     */
    public void setUsers(Set<AppUser> users) {
        this.users = users;
    }

}
