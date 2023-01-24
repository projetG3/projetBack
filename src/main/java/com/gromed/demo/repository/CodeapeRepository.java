package com.example.demo.repository;

import com.example.demo.models.Codeape;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CodeapeRepository extends JpaRepository<Codeape, String> {
}