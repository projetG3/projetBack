package com.gromed.demo.service;

import com.gromed.demo.model.Apourgenerique;
import com.gromed.demo.model.ApourgeneriqueId;
import com.gromed.demo.repository.ApourgeneriqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApourgeneriqueService {

    @Autowired
    private ApourgeneriqueRepository apourgeneriqueRepository;

    public Optional<Apourgenerique> getGenerique(ApourgeneriqueId id) {
        return apourgeneriqueRepository.findById(id);
    }

    public List<Apourgenerique> getAllGenerique() {
        return apourgeneriqueRepository.findAll();
    }

    public void deleteGenerique(ApourgeneriqueId id) {
        apourgeneriqueRepository.deleteById(id);
    }

    public Apourgenerique saveGenerique(Apourgenerique id){
        return apourgeneriqueRepository.save(id);
    }

}