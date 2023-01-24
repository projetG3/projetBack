package com.example.demo.repository;

import com.example.demo.models.Avis;
import com.example.demo.models.AvisId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvisRepository extends JpaRepository<Avis, AvisId> {
}