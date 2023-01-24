package com.gromed.demo.repository;

import com.gromed.demo.model.Administrepar;
import com.gromed.demo.model.AdministreparId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministreparRepository extends JpaRepository<Administrepar, AdministreparId> {
}