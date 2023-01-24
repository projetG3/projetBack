package com.gromed.demo.repository;

import com.gromed.demo.model.Informationsimportante;
import com.gromed.demo.model.InformationsimportanteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationsimportanteRepository extends JpaRepository<Informationsimportante, InformationsimportanteId> {
}