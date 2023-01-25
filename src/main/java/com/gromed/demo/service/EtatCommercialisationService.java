package com.gromed.demo.service;

import com.gromed.demo.model.EtatCommercialisation;
import com.gromed.demo.model.FormePharmaceutique;
import com.gromed.demo.repository.EtatCommercialisationRepository;
import com.gromed.demo.repository.FormePharmaceutiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtatCommercialisationService {

    @Autowired
    EtatCommercialisationRepository etatCommercialisationRepository;

    public Optional<EtatCommercialisation> getEtatcommercial(String id) {
        return etatCommercialisationRepository.findById(id);
    }

    public List<EtatCommercialisation> getAllEtatcommercial() {
        return etatCommercialisationRepository.findAll();
    }

    public void deleteEtatcommercial(String id) {
        etatCommercialisationRepository.deleteById(id);
    }

    public EtatCommercialisation saveEtatcommercial(EtatCommercialisation id){
        return etatCommercialisationRepository.save(id);
    }
}
