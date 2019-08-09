package com.app.binouz.security;

/**
 * Création de l'interface SecurirtyService pour fournir le login actuelle et
 * l'auto login après l'enregistrement
 *
 * @author Matthieu Delomez
 */
public interface SecurityService {

    /**
     *
     * @return Logged success
     */
    String findLoggedInUsername();

    /**
     * Méthode qui va nous permettre de nous logger une fois l'utilisateur
     * enregistré
     *
     * @param username - Pseudo
     * @param password - Mot de passe
     */
    void autoLogin(String username, String password);

}
