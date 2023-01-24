package com.gromed.demo.repository;

import com.gromed.demo.model.Avis;
import com.gromed.demo.model.AvisId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvisRepository extends JpaRepository<Avis, AvisId> {
}