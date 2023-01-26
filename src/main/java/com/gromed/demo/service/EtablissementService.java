package com.gromed.demo.service;

import com.gromed.demo.model.Etablissement;
import com.gromed.demo.repository.EtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtablissementService {

    @Autowired
    private EtablissementRepository etablissementRepository;

    public Optional<Etablissement> getEtablissement(Long id) {
        return etablissementRepository.findById(id);
    }

    public List<Etablissement> getAllEtablissement() {
        return etablissementRepository.findAll();
    }

    public void deleteEtablissement(Long id) {
        etablissementRepository.deleteById(id);
    }

    public Etablissement saveEtablissement(Etablissement id){
        return etablissementRepository.save(id);
    }
}
