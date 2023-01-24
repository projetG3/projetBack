package com.gromed.demo.service;

import com.gromed.demo.model.Estcreepar;
import com.gromed.demo.model.EstcreeparId;
import com.gromed.demo.repository.EstcreeparRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstcreeparService {

    @Autowired
    private EstcreeparRepository estcreeparRepository;

    public Optional<Estcreepar> getEstcreepar(EstcreeparId id) {
        return estcreeparRepository.findById(id);
    }

    public List<Estcreepar> getAllEstcreepars() {
        return estcreeparRepository.findAll();
    }

    public void deleteEstcreepar(EstcreeparId id) {
        estcreeparRepository.deleteById(id);
    }

    public Estcreepar saveEstcreepar(Estcreepar id){
        return estcreeparRepository.save(id);
    }
}
