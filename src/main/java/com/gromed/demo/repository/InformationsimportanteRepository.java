package com.example.demo.repository;

import com.example.demo.models.Informationsimportante;
import com.example.demo.models.InformationsimportanteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationsimportanteRepository extends JpaRepository<Informationsimportante, InformationsimportanteId> {
}