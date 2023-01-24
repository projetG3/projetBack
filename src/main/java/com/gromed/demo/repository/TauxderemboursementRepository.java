package com.example.demo.repository;

import com.example.demo.models.Tauxderemboursement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TauxderemboursementRepository extends JpaRepository<Tauxderemboursement, Long> {
}