package com.gromed.demo.repository;

import com.gromed.demo.model.Apourgenerique;
import com.gromed.demo.model.ApourgeneriqueId;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ApourgeneriqueRepository extends JpaRepository<Apourgenerique, ApourgeneriqueId> {
}