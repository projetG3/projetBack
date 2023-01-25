package com.gromed.demo.service;

import com.gromed.demo.model.Avis;
import com.gromed.demo.repository.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvisService {

    @Autowired
    AvisRepository avisRepository;

    public Optional<Avis> getAvis(Integer id) {
        return avisRepository.findById(id);
    }

    public List<Avis> getAllAvis() {
        return avisRepository.findAll();
    }

    public void deleteAvis(Integer id) {
        avisRepository.deleteById(id);
    }

    public Avis saveAvis(Avis id){
        return avisRepository.save(id);
    }
}
