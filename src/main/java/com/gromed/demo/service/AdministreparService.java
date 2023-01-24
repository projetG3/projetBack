package com.gromed.demo.service;

import com.gromed.demo.model.Administrepar;
import com.gromed.demo.model.AdministreparId;
import com.gromed.demo.repository.AdministreparRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministreparService {

    @Autowired
    private AdministreparRepository administreparRepository;

    public Optional<Administrepar> getAdministrepar(AdministreparId id) {
        return administreparRepository.findById(id);
    }

    public List<Administrepar> getAllAdministrepars() {
        return administreparRepository.findAll();
    }

    public void deleteAdministrepar(AdministreparId id) {
        administreparRepository.deleteById(id);
    }

    public Administrepar saveAdministrepar(Administrepar id){
        return administreparRepository.save(id);
    }
}
