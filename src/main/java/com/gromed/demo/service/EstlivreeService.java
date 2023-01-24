package com.gromed.demo.service;

import com.gromed.demo.model.Compte;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EstlivreeService {

    @Autowired
    private EstlivreeRepository estlivreeRepository;

    public Optional<Compte> getCompte(Integer id) {
        return compteRepository.findById(id);
    }

    public List<Compte> getAllComptes() {
        return compteRepository.findAll();
    }

    public void deleteCompte(Integer id) {
        compteRepository.deleteById(id);
    }

    public Compte saveCompte(Compte id){
        return compteRepository.save(id);
    }
}
