package com.gromed.demo.repository;

import com.gromed.demo.model.Informe;
import com.gromed.demo.model.InformeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformeRepository extends JpaRepository<Informe, InformeId> {
}