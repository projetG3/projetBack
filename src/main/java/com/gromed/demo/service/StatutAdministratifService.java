package com.gromed.demo.service;

import com.gromed.demo.model.StatutAdministratif;
import com.gromed.demo.repository.StatutAdministratifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatutAdministratifService {

    @Autowired
    StatutAdministratifRepository statutAdministratifRepository;

    public Optional<StatutAdministratif> getAdministratif(String id) {
        return statutAdministratifRepository.findById(id);
    }

    public List<StatutAdministratif> getAllAdministratif() {
        return statutAdministratifRepository.findAll();
    }

    public void deleteAdministratif(String id) {
        statutAdministratifRepository.deleteById(id);
    }

    public StatutAdministratif saveAdministratif(StatutAdministratif id){
        return statutAdministratifRepository.save(id);
    }
}
