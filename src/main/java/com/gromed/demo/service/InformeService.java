package com.gromed.demo.service;

import com.gromed.demo.model.Informe;
import com.gromed.demo.repository.InformeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformeService {

    @Autowired
    private InformeRepository informeRepository;

    public Optional<Informe> getInforme(final Integer id) {
        return informeRepository.findById(id);
    }

    public List<Informe> getAllInforme() {
        return informeRepository.findAll();
    }

    public void deleteInforme(final Integer id) {
        informeRepository.deleteById(id);
    }

    public Informe saveInforme(Informe info){
        return informeRepository.save(info);
    }
}
