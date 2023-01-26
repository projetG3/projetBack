package com.gromed.demo.service;

import com.gromed.demo.model.Categorieetablissement;
import com.gromed.demo.repository.CategorieetablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieetablissementService {

    @Autowired
    private CategorieetablissementRepository categorieetablissementRepository;

    public Optional<Categorieetablissement> getCategorieEtablissement(Long id) {
        return categorieetablissementRepository.findById(id);
    }

    public List<Categorieetablissement> getAllCategorieEtablissement() {
        return categorieetablissementRepository.findAll();
    }

    public void deleteCategorieEtablissement(Long id) {
        categorieetablissementRepository.deleteById(id);
    }

    public Categorieetablissement saveCategorieEtablissement(Categorieetablissement id){
        return categorieetablissementRepository.save(id);
    }
}
