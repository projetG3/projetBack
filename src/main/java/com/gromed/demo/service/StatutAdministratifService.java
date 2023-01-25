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
    private StatutAdministratifRepository statutAdministratifRepository;

    public Optional<StatutAdministratif> getGenerique(String id) {
        return statutAdministratifRepository.findById(id);
    }

    public List<StatutAdministratif> getAllGeneriques() {
        return statutAdministratifRepository.findAll();
    }

    public void deleteGenerique(String id) {
        statutAdministratifRepository.deleteById(id);
    }

    public StatutAdministratif saveGenerique(StatutAdministratif id){
        return statutAdministratifRepository.save(id);
    }
}
