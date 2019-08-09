package com.app.binouz.dao;

import com.app.binouz.model.Bar;
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
public interface BarRepository extends JpaRepository<Bar, Integer> {

    /**
     * Retourne une liste de bar en fonction du nom de ce dernier
     *
     * @param nom - Générer une liste par le nom des bars
     * @return - Liste Bar
     */
    List<Bar> findByNom(String nom);

    /**
     * Methode qui va nous permettre du suprimer un bar en fonction de son nom
     * via l'annotation @Query
     *
     * @param nom - Supression d'un bar par son nom
     */
    @Transactional
    @Modifying
    @Query(value = "delete from Bar c where c.nom = ?1")
    void deleteByNom(String nom);

}
