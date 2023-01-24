package com.example.demo.repository;

import com.example.demo.models.Apourgenerique;
import com.example.demo.models.ApourgeneriqueId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApourgeneriqueRepository extends JpaRepository<Apourgenerique, ApourgeneriqueId> {
}