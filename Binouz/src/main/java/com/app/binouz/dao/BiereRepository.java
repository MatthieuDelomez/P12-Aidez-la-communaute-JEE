package com.app.binouz.dao;

import com.app.binouz.model.Biere;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Spring Data JPA qui va contenir les builds du Repository pour implémenter les
 * fonctions courantes de la base de données
 *
 * @author Matthieu Delomez
 */
@Repository
public interface BiereRepository extends JpaRepository<Biere, Long> {

    /**
     * Methode @Query qui va nous permettre de rechercher une biere en fonction
     * de son nom
     *
     * @param nombiere - Nom de la bière
     * @return - Retourne la liste de notre recherche en fonction du nom
     */
    @Query("SELECT e FROM Biere e WHERE e.nombiere LIKE %?1")
    public List<Biere> findByNombiere(String nombiere);

    /**
     * Supression d'une biere en fonction de son Id via l'annotation @Query
     *
     * @param idbiere - supression via id
     */
    @Transactional
    @Modifying
    @Query(value = "delete from Biere c where c.idbiere = ?1")
    void deleteByNombiere(Long idbiere);

}
