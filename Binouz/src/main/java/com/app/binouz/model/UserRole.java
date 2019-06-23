
package com.app.binouz.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name = "user_roles")
public class UserRole implements Serializable{
    
                     @Id
                     @GeneratedValue
                      @Column(name = "userroleid", nullable = false)
                      private Long userRoleId;
                      @Column(name = "role", length =45 , nullable = false)
                      private String role;
                       @Column(name = "username", length = 36, nullable = false)
	private AppUser username;
        
        
                      public UserRole() {
	}

	public UserRole(AppUser username, String role) {
		this.username = username;
		this.role = role;
	}

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

    public AppUser getUsername() {
        return username;
    }

    public void setUsername(AppUser username) {
        this.username = username;
    }
        
        
}
   
 