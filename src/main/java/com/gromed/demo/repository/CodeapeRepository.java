package com.gromed.demo.repository;

import com.gromed.demo.model.Codeape;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeapeRepository extends JpaRepository<Codeape, String> {
}