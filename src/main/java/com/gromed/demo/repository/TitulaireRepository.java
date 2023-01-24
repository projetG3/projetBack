package com.gromed.demo.repository;

import com.gromed.demo.model.Titulaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitulaireRepository extends JpaRepository<Titulaire, String> {
}