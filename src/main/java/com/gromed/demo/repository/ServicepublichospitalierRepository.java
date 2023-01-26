package com.gromed.demo.repository;

import com.gromed.demo.model.Servicepublichospitalier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicepublichospitalierRepository extends JpaRepository<Servicepublichospitalier, Long> {
}