package com.gromed.demo.repository;

import com.gromed.demo.model.Estrembourseea;
import com.gromed.demo.model.EstrembourseeaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstrembourseeaRepository extends JpaRepository<Estrembourseea, EstrembourseeaId> {
}