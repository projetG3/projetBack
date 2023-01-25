package com.gromed.demo.service;

import com.gromed.demo.model.FormePharmaceutique;
import com.gromed.demo.repository.FormePharmaceutiqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormePharmaceutiqueService {

    @Autowired
    FormePharmaceutiqueRepository formePharmaceutiqueRepository;

    public Optional<FormePharmaceutique> getFormePharmaceutique(String id) {
        return formePharmaceutiqueRepository.findById(id);
    }

    public List<FormePharmaceutique> getAllFormePharmaceutique() {
        return formePharmaceutiqueRepository.findAll();
    }

    public void deleteFormePharmaceutique(String id) {
        formePharmaceutiqueRepository.deleteById(id);
    }

    public FormePharmaceutique saveFormePharmaceutique(FormePharmaceutique id){
        return formePharmaceutiqueRepository.save(id);
    }
}
