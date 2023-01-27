package com.gromed.demo.repository;

import com.gromed.demo.model.Estlivree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstlivreeRepository extends JpaRepository<Estlivree, Long> {
}