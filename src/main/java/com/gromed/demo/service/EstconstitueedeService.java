package com.gromed.demo.service;

import com.gromed.demo.model.Estconstitueede;
import com.gromed.demo.model.EstconstitueedeId;
import com.gromed.demo.repository.EstconstitueedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstconstitueedeService {

    @Autowired
    private EstconstitueedeRepository estconstitueedeRepository;

    public Optional<Estconstitueede> getEstconstitueede(EstconstitueedeId id) {
        return estconstitueedeRepository.findById(id);
    }

    public List<Estconstitueede> getAllEstconstitueedes() {
        return estconstitueedeRepository.findAll();
    }

    public void deleteEstconstitueede(EstconstitueedeId id) {
        estconstitueedeRepository.deleteById(id);
    }

    public Estconstitueede saveEstconstitueede(Estconstitueede id){
        return estconstitueedeRepository.save(id);
    }
}
