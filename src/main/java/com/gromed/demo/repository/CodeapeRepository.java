package com.gromed.demo.repository;

import com.gromed.demo.model.Codeape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeapeRepository extends JpaRepository<Codeape, String> {
}