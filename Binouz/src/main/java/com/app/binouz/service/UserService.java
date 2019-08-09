package com.app.binouz.service;

import com.app.binouz.model.AppUser;
import org.springframework.stereotype.Service;

/**
 * Fournir le service necessaire à l'enregistrement du compte d'un utilisateur.
 * Implementation de l'interface UserService où nous allons définir les méthodes
 * save et findByUsername
 *
 * @author Matthieu Delomez
 */
@Service
public interface UserService {

    /**
     * Méthode save qui va permettre l'enregistrement d'un utilisateur en base.
     *
     * @param user - Utilisateur
     */
    void save(AppUser user);

    /**
     * Appel de la méthode du userRepository avec l'utilisation de JPA Méthode
     * qui retourne un utilisateur via son username
     *
     * @param username - Pseudo de l'utilisateur
     * @return - UserRepository
     */
    AppUser findByUsername(String username);

}
