package com.gromed.demo.service;


import com.gromed.demo.model.Estdelivresous;
import com.gromed.demo.model.EstdelivresousId;
import com.gromed.demo.repository.EstdelivresousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstdelivresousService {
    @Autowired
    private EstdelivresousRepository estdelivresousRepository;

    public Optional<Estdelivresous> getEstdelivresous(EstdelivresousId id) {
        return estdelivresousRepository.findById(id);
    }

    public List<Estdelivresous> getAllEstdelivresouss() {
        return estdelivresousRepository.findAll();
    }

    public void deleteEstdelivresous(EstdelivresousId id) {
        estdelivresousRepository.deleteById(id);
    }

    public Estdelivresous saveEstdelivresous(Estdelivresous id){
        return estdelivresousRepository.save(id);
    }
}
