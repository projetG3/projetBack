package com.gromed.demo.service;

import com.gromed.demo.model.Compte;
import com.gromed.demo.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

    public Optional<Compte> getCompte(Long id) {
        return compteRepository.findById(id);
    }

    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    public void deleteCompte(Long id) {
        compteRepository.deleteById(id);
    }

    public Compte saveCompte(Compte id){
        return compteRepository.save(id);
    }
}
