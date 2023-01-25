package com.gromed.demo.repository;

import com.gromed.demo.model.TypeProcedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeProcedureRepository extends JpaRepository<TypeProcedure, String> {
}