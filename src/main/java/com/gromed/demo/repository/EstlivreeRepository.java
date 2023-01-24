package com.gromed.demo.repository;

import com.gromed.demo.model.Estlivree;
import com.gromed.demo.model.EstlivreeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstlivreeRepository extends JpaRepository<Estlivree, EstlivreeId> {
}