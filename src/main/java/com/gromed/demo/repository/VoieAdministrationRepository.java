package com.gromed.demo.repository;

import com.gromed.demo.model.VoieAdministration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoieAdministrationRepository extends JpaRepository<VoieAdministration, String> {
}