
package com.app.binouz.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name= "utilisateur_roles")
public class UserRole implements Serializable{
    
                     @Id
                     @GeneratedValue(strategy = GenerationType.AUTO)
                      @Column(name = "userroleid", nullable = false)
                      private Long userRoleId;
                     
                      
                       @Column(name = "rolename", length = 45, nullable = false)
	private String role;
                       

                       
                       @ManyToMany  @JoinTable (name= "app_user_roles", joinColumns = @JoinColumn 
                       (name = "roles_userroleid"), inverseJoinColumns = @JoinColumn(name = "app_user_username"))
                       
                        private Set<AppUser> users;
                       
                       
                       

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<AppUser> getUsers() {
        return users;
    }

    public void setUsers(Set<AppUser> users) {
        this.users = users;
    }
                       
                       

                       
                       

        
        

  
    
    


    
    
        
        
}
   
 