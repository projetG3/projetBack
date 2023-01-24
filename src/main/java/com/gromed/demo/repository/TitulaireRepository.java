package com.example.demo.repository;

import com.example.demo.models.Titulaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitulaireRepository extends JpaRepository<Titulaire, String> {
}