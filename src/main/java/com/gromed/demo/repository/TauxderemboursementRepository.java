package com.gromed.demo.repository;

import com.gromed.demo.model.Tauxderemboursement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TauxderemboursementRepository extends JpaRepository<Tauxderemboursement, Long> {
}