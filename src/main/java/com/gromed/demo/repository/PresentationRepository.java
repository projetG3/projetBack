package com.gromed.demo.repository;

import com.gromed.demo.model.CritereRecherche;
import com.gromed.demo.model.Presentation;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.List;

@Repository
public interface PresentationRepository extends JpaRepository<Presentation, Long> {

    /*
    @Query("SELECT p FROM presentation p " +
            "JOIN p.codecis c " +
            "LEFT JOIN p.apourgenerique a " +
            "LEFT JOIN a.generique g " +
            "WHERE p.etatcommercialisation = 'Déclaration de commercialisation' " +
            "AND (:critereRecherche.codecis.nom IS NULL OR c.nom LIKE %:critereRecherche.codecis.nom%) " +
            "AND (:critereRecherche.libelle IS NULL OR p.libelle LIKE %:critereRecherche.libelle%) " +
            "AND (:critereRecherche.generique IS NULL OR g.libelle LIKE %:critereRecherche.generique%) " +
            ")")
    */
    //public List<Presentation> getPresentationsByCriteria(CritereRecherche critereRecherche);

}