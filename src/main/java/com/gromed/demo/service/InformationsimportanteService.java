package com.gromed.demo.service;

import com.gromed.demo.model.Informationsimportante;
import com.gromed.demo.model.InformationsimportanteId;
import com.gromed.demo.repository.InformationsimportanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformationsimportanteService {

    @Autowired
    private InformationsimportanteRepository informationsimportanteRepository;
    
    public Optional<Informationsimportante> getInformationsimportante(InformationsimportanteId id) {
        return informationsimportanteRepository.findById(id);
    }

    public List<Informationsimportante> getAllInformationsimportantes() {
        return informationsimportanteRepository.findAll();
    }

    public void deleteInformationsimportante(InformationsimportanteId id) {
        informationsimportanteRepository.deleteById(id);
    }

    public Informationsimportante saveInformationsimportante(Informationsimportante id){
        return informationsimportanteRepository.save(id);
    }
}
