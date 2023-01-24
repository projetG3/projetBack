package com.example.demo.repository;

import com.example.demo.models.Generique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneriqueRepository extends JpaRepository<Generique, Long> {
}