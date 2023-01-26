package com.gromed.demo.repository;

import com.gromed.demo.model.Categorieetablissement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieetablissementRepository extends JpaRepository<Categorieetablissement, Long> {
}