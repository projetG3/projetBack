package com.gromed.demo.service;

import com.gromed.demo.model.VoieAdministration;
import com.gromed.demo.repository.VoieAdministrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoieAdministrationService {

    @Autowired
    private VoieAdministrationRepository voieAdministrationRepository;

    public Optional<VoieAdministration> getVoieAdministration(final String nom) {
        return voieAdministrationRepository.findById(nom);
    }

    public List<VoieAdministration> getAllVoieAdministration() {
        return voieAdministrationRepository.findAll();
    }

    public void deleteVoieAdministration(final String nom) {
        voieAdministrationRepository.deleteById(nom);
    }

    public VoieAdministration saveVoieAdministration(VoieAdministration voieAdministration){
        return voieAdministrationRepository.save(voieAdministration);
    }
}
