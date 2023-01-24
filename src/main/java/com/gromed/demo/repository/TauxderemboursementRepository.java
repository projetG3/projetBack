package com.gromed.demo.repository;

import com.gromed.demo.model.Tauxderemboursement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TauxderemboursementRepository extends JpaRepository<Tauxderemboursement, String> {
}