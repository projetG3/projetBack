package com.gromed.demo.repository;

import com.gromed.demo.model.EtatCommercialisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatCommercialisationRepository extends JpaRepository<EtatCommercialisation, String> {
}