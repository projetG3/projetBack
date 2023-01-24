package com.gromed.demo.repository;

import com.gromed.demo.model.Estrembourseea;
import com.gromed.demo.model.EstrembourseeaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstrembourseeaRepository extends JpaRepository<Estrembourseea, EstrembourseeaId> {
}