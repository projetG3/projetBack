package com.gromed.demo.service;

import com.gromed.demo.model.Medicament;
import com.gromed.demo.repository.MedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentService {

    @Autowired
    MedicamentRepository medicamentRepository;

    public Optional<Medicament> getMedicament(Long id) {
        return medicamentRepository.findById(id);
    }

    public List<Medicament> getAllMedicament() {
        return medicamentRepository.findAll();
    }

    public void deleteMedicament(Long id) {
        medicamentRepository.deleteById(id);
    }

    public Medicament saveMedicament(Medicament medoc){
        return medicamentRepository.save(medoc);
    }
}
