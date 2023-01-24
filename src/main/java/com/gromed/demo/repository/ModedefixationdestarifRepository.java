package com.gromed.demo.repository;

import com.gromed.demo.model.Modedefixationdestarif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModedefixationdestarifRepository extends JpaRepository<Modedefixationdestarif, Integer> {
}