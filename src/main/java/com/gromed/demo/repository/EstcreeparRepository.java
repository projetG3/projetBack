package com.gromed.demo.repository;

import com.gromed.demo.model.Estcreepar;
import com.gromed.demo.model.EstcreeparId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstcreeparRepository extends JpaRepository<Estcreepar, EstcreeparId> {
}