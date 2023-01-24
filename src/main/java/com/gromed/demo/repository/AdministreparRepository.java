package com.example.demo.repository;

import com.example.demo.models.Administrepar;
import com.example.demo.models.AdministreparId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministreparRepository extends JpaRepository<Administrepar, AdministreparId> {
}