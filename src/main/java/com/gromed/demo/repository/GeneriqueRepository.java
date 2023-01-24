package com.gromed.demo.repository;

import com.gromed.demo.model.Generique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneriqueRepository extends JpaRepository<Generique, Long> {
}