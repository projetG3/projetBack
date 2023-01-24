package com.gromed.demo.repository;

import com.gromed.demo.model.Estdelivresous;
import com.gromed.demo.model.EstdelivresousId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstdelivresousRepository extends JpaRepository<Estdelivresous, EstdelivresousId> {
}