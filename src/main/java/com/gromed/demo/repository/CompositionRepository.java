package com.gromed.demo.repository;

import com.gromed.demo.model.Composition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompositionRepository extends JpaRepository<Composition, Long> {
}