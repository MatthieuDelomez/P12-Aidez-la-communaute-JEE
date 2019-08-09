package com.app.binouz.dao;

import com.app.binouz.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA qui va contenir les builds du Repository pour implémenter les
 * fonctions courantes de la base de données
 *
 * @author Matthieu Delomez
 */
@Repository
public interface UserRepository extends JpaRepository<AppUser, String> {

    /**
     * Méthode qui retourne un utilisateur via son username
     *
     * @param username - Pseudo de l'utilisateur
     * @return - Retourne l'utilisateur en fonction de son pseudo
     */
    AppUser findByUsername(String username);

}
