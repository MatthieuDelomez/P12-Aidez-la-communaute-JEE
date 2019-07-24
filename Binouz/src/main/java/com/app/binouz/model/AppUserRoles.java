
package com.app.binouz.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name= "app_user_roles")
public class AppUserRoles implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "idref")
    private Long idRef;    
    
   @Column(name = "roles_userroleid", unique = false)
    private String rolesuserroleid;
    
   @Column(name = "app_user_username" )
    private String appuserusername;

   
   
    public String getRolesuserroleid() {
        return rolesuserroleid;
    }

    public void setRolesuserroleid(String rolesuserroleid) {
        this.rolesuserroleid = rolesuserroleid;
    }

    public String getAppuserusername() {
        return appuserusername;
    }

    public void setAppuserusername(String appuserusername) {
        this.appuserusername = appuserusername;
    }

    public Long getIdRef() {
        return idRef;
    }

    public void setIdRef(Long idRef) {
        this.idRef = idRef;
    }
    
    

    public AppUserRoles() {
        super();
    }

    public AppUserRoles(String rolesuserroleid, String appuserusername) {
        this.rolesuserroleid = rolesuserroleid;
        this.appuserusername = appuserusername;
    }
    
    
   
   
   
   
    
}
