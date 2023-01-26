package com.gromed.demo.service;

import com.gromed.demo.model.Composition;
import com.gromed.demo.repository.CompositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompositionsService {

    @Autowired
    private CompositionRepository compositionRepository;

    public Optional<Composition> getComposition(Long id) {
        return compositionRepository.findById(id);
    }

    public List<Composition> getAllComposition() {
        return compositionRepository.findAll();
    }

    public void deleteComposition(Long id) {
        compositionRepository.deleteById(id);
    }

    public Composition saveComposition(Composition id){
        return compositionRepository.save(id);
    }
}
