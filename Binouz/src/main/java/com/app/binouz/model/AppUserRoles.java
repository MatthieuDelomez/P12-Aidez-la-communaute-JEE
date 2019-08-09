package com.app.binouz.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Création de notre classe entité qui va nous permettre de faire la jonction
 * entre notre base de données et notre classe Java. Classe qui correspond à
 * notre définition des rôles
 *
 * @author Matthieu Delomez
 */
@Entity
@Table(name = "app_user_roles")
public class AppUserRoles implements Serializable {

    /*
   * Création des variables qui font références aux colonnes 
   * présentes en base
   * 
   * @Id: Définition de la clé primaire
   * @GeneratedValue: Définir notre Id en AutoIncrement
   * @Column: Configuration des colonnes présentes en base
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idref")
    private Long idRef;

    @Column(name = "roles_userroleid", unique = false)
    private String rolesuserroleid;

    @Column(name = "app_user_username")
    private String appuserusername;

    
    /*
    ************************************************************
                  INVOCATION DES GETTES & SETTERS
    ************************************************************
     */
    /**
     *
     * @return rolesuserroleid
     */
    public String getRolesuserroleid() {
        return rolesuserroleid;
    }

    /**
     *
     * @param rolesuserroleid - Id du role user
     */
    public void setRolesuserroleid(String rolesuserroleid) {
        this.rolesuserroleid = rolesuserroleid;
    }

    /**
     *
     * @return appuserusername
     */
    public String getAppuserusername() {
        return appuserusername;
    }

    /**
     *
     * @param appuserusername - Username de l'utilisateur
     */
    public void setAppuserusername(String appuserusername) {
        this.appuserusername = appuserusername;
    }

    /**
     *
     * @return idRef
     */
    public Long getIdRef() {
        return idRef;
    }

    /**
     *
     * @param idRef -  Reference id
     */
    public void setIdRef(Long idRef) {
        this.idRef = idRef;
    }

    /**
     * Constructeur sans paramètre
     */
    public AppUserRoles() {
        super();
    }

    /**
     *
     * @param rolesuserroleid - role id
     * @param appuserusername - app_user_username
     */
    public AppUserRoles(String rolesuserroleid, String appuserusername) {
        this.rolesuserroleid = rolesuserroleid;
        this.appuserusername = appuserusername;
    }

}
