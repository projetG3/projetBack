package com.gromed.demo.service;

import com.gromed.demo.model.Generique;
import com.gromed.demo.repository.GeneriqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneriqueService {

    @Autowired
    private GeneriqueRepository generiqueRepository;

    public Optional<Generique> getGenerique(Integer id) {
        return generiqueRepository.findById(id);
    }

    public List<Generique> getAllGeneriques() {
        return generiqueRepository.findAll();
    }

    public void deleteGenerique(Integer id) {
        generiqueRepository.deleteById(id);
    }

    public Generique saveGenerique(Generique id){
        return generiqueRepository.save(id);
    }
}
