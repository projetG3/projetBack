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
    private FormePharmaceutiqueRepository formePharmaceutiqueRepository;

    public Optional<FormePharmaceutique> getGenerique(String id) {
        return formePharmaceutiqueRepository.findById(id);
    }

    public List<FormePharmaceutique> getAllGeneriques() {
        return formePharmaceutiqueRepository.findAll();
    }

    public void deleteGenerique(String id) {
        formePharmaceutiqueRepository.deleteById(id);
    }

    public FormePharmaceutique saveGenerique(FormePharmaceutique id){
        return formePharmaceutiqueRepository.save(id);
    }
}
