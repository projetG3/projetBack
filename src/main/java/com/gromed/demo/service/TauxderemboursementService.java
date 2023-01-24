package com.gromed.demo.service;

import com.gromed.demo.model.Tauxderemboursement;
import com.gromed.demo.repository.TauxderemboursementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TauxderemboursementService {

    @Autowired
    private TauxderemboursementRepository tauxderemboursementRepository;

    public Optional<Tauxderemboursement> getTauxDeRemboursement(final String taux) {
        return tauxderemboursementRepository.findById(taux);
    }

    public List<Tauxderemboursement> getAllTauxDeRemboursement() {
        return tauxderemboursementRepository.findAll();
    }

    public void deleteTauxDeRemboursement(final String taux) {
        tauxderemboursementRepository.deleteById(taux);
    }

    public Tauxderemboursement saveTauxDeRemboursement(Tauxderemboursement tauxderemboursement){
        return tauxderemboursementRepository.save(tauxderemboursement);
    }
}
