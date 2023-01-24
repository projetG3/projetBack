package com.gromed.demo.repository;

import com.gromed.demo.model.Conditionsmedicamenteuse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionsmedicamenteuseRepository extends JpaRepository<Conditionsmedicamenteuse, String> {
}