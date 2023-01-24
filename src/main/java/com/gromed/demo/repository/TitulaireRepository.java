package com.gromed.demo.repository;

import com.gromed.demo.model.Titulaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitulaireRepository extends JpaRepository<Titulaire, String> {
}