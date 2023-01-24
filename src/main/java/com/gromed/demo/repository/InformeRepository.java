package com.example.demo.repository;

import com.example.demo.models.Informe;
import com.example.demo.models.InformeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformeRepository extends JpaRepository<Informe, InformeId> {
}