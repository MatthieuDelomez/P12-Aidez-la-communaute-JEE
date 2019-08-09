package com.app.binouz.dao;

import com.app.binouz.model.UserRole;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA qui va contenir les builds du Repository pour implémenter les
 * fonctions courante de la base de données
 *
 * @author Matthieu Delomez
 */
@Repository
public interface RoleRepository extends JpaRepository<UserRole, Long> {

    /**
     * Methode qui va nous permettre de definir le role lors de l'enregistrement
     * d'un utilisateur 
     *
     * @param role - Role de l'utilisateur
     * @return - Retourne une liste en fonction du rôle
     */
    public List<UserRole> findByRole(String role);

}
