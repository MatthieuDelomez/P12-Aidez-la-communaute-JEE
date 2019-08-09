package com.app.binouz.dao;

import com.app.binouz.model.Commentaire;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring Data JPA qui va contenir les build du Repository pour implémenter les
 * fonctions courantes de la base de données
 *
 * @author Matthieu Delomez
 */
@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

    /**
     * Generer une liste de commentaires by username
     *
     * @param username - Pseudo de de la personne qui à rédigé le commentaire
     * @return - Liste de commentaire
     */
    List<Commentaire> findByUsername(String username);

    /**
     * Supression du commentaire souhaité grace à son Id
     *
     * @param idcom - Id du commentaire 
     */
    @Transactional
    @Modifying
    @Query(value = "delete from Commentaire c where c.idcom = ?1")
    void deleteById(Long idcom);

}
