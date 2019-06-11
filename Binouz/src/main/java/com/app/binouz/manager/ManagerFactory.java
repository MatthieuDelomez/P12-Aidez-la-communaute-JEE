
package com.app.binouz.manager;


public interface ManagerFactory {
    
    
    /*********************************************************************************/
    
    ManagerAdministrateur getManagerAdministrateur();
    
    void setManagerAdministrateur(ManagerAdministrateur managerAdministrateur);
    
    /*********************************************************************************/
    
    ManagerBar getManagerBar();
    
    void setManagerBar(ManagerBar managerBar);
    
    /*********************************************************************************/
    
    ManagerBiere getManagerBiere();
    
    void setManagerBiere(ManagerBiere managerBiere);
    
    /*********************************************************************************/
    
    ManagerCommentaire getManagerCommentaire();
    
    void setManagerCommentaire(ManagerCommentaire managerCommentaire);
    
    /*********************************************************************************/
    
     ManagerPatronBar getManagePatronBar();
    
    void setManagerPatronBar(ManagerPatronBar managerPatronBar);
    
    /*********************************************************************************/
    
     ManagerUtilisateur getManagerUtilisateur();
    
    void setManagerUtilisateur(ManagerUtilisateur managerUtilisateur);
    
    /*********************************************************************************/
    
    
    
}
