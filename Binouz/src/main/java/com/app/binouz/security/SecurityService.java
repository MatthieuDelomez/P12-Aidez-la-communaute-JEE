
package com.app.binouz.security;



public interface SecurityService {
    
    
    String findLoggedInUsername();
    
    void autoLogin(String username, String password);
    
}
