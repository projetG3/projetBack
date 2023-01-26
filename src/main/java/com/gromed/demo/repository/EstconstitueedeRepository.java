package com.gromed.demo.repository;

import com.gromed.demo.model.Estconstitueede;
import com.gromed.demo.model.EstconstitueedeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstconstitueedeRepository extends JpaRepository<Estconstitueede, EstconstitueedeId> {
}