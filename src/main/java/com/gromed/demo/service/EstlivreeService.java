package com.gromed.demo.service;

import com.gromed.demo.model.Estlivree;
import com.gromed.demo.repository.EstlivreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstlivreeService {

    @Autowired
    private EstlivreeRepository estlivreeRepository;

    public Optional<Estlivree> getEstlivree(Long id) {
        return estlivreeRepository.findById(id);
    }

    public List<Estlivree> getAllEstlivrees() {
        return estlivreeRepository.findAll();
    }

    public void deleteEstlivree(Long id) {
        estlivreeRepository.deleteById(id);
    }

    public Estlivree saveEstlivree(Estlivree id){
        return estlivreeRepository.save(id);
    }
}
