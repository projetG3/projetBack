package com.gromed.demo.repository;

import com.gromed.demo.model.FormePharmaceutique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormePharmaceutiqueRepository extends JpaRepository<FormePharmaceutique, String> {
}