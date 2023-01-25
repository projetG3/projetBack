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
    private EtatCommercialisationRepository etatCommercialisationRepository;

    public Optional<EtatCommercialisation> getGenerique(String id) {
        return etatCommercialisationRepository.findById(id);
    }

    public List<EtatCommercialisation> getAllGeneriques() {
        return etatCommercialisationRepository.findAll();
    }

    public void deleteGenerique(String id) {
        etatCommercialisationRepository.deleteById(id);
    }

    public EtatCommercialisation saveGenerique(EtatCommercialisation id){
        return etatCommercialisationRepository.save(id);
    }
}
