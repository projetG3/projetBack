package com.example.demo.repository;

import com.example.demo.models.Estlivree;
import com.example.demo.models.EstlivreeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstlivreeRepository extends JpaRepository<Estlivree, EstlivreeId> {
}