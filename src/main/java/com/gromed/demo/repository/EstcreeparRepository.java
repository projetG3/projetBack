package com.example.demo.repository;

import com.example.demo.models.Estcreepar;
import com.example.demo.models.EstcreeparId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstcreeparRepository extends JpaRepository<Estcreepar, EstcreeparId> {
}