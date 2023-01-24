package com.gromed.demo.service;

import com.gromed.demo.model.Estrembourseea;
import com.gromed.demo.model.EstrembourseeaId;
import com.gromed.demo.repository.EstrembourseeaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstrembourseeaService {

    @Autowired
    private EstrembourseeaRepository estrembourseeaRepository;

    public Optional<Estrembourseea> getRembourse(EstrembourseeaId id) {
        return estrembourseeaRepository.findById(id);
    }

    public List<Estrembourseea> getAllRembourse() {
        return estrembourseeaRepository.findAll();
    }

    public void deleteRembourse(EstrembourseeaId id) {
        estrembourseeaRepository.deleteById(id);
    }

    public Estrembourseea saveRembourse(Estrembourseea id){
        return estrembourseeaRepository.save(id);
    }
}
