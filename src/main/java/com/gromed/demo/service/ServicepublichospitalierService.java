package com.gromed.demo.service;

import com.gromed.demo.model.Servicepublichospitalier;
import com.gromed.demo.repository.ServicepublichospitalierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicepublichospitalierService {

    @Autowired
    private ServicepublichospitalierRepository servicepublichospitalierRepository;

    public Optional<Servicepublichospitalier> getServicePubliqueHospitalier(final Integer id) {
        return servicepublichospitalierRepository.findById(id);
    }

    public List<Servicepublichospitalier> getAllServicePubliqueHospitalier() {
        return servicepublichospitalierRepository.findAll();
    }

    public void deleteServicePubliqueHospitalier(final Integer id) {
        servicepublichospitalierRepository.deleteById(id);
    }

    public Servicepublichospitalier saveServicePubliqueHospitalier(Servicepublichospitalier servicepublichospitalier){
        return servicepublichospitalierRepository.save(servicepublichospitalier);
    }
}
