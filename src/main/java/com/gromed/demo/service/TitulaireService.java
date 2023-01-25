package com.gromed.demo.service;

import com.gromed.demo.model.Titulaire;
import com.gromed.demo.repository.TitulaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitulaireService {

    @Autowired
    private TitulaireRepository titulaireRepository;
    public Optional<Titulaire> getTitulaire(final String nom) {
        return titulaireRepository.findById(nom);
    }

    public List<Titulaire> getAllTitulaire() {
        return titulaireRepository.findAll();
    }

    public void deleteTitulaire(final String nom) {
        titulaireRepository.deleteById(nom);
    }

    public Titulaire saveTitulaire(Titulaire titulaire){
        return titulaireRepository.save(titulaire);
    }
}
