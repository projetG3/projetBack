package com.gromed.demo.repository;

import com.gromed.demo.model.Informationsimportante;
import com.gromed.demo.model.InformationsimportanteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationsimportanteRepository extends JpaRepository<Informationsimportante, InformationsimportanteId> {
}