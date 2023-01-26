package com.gromed.demo.service;

import com.gromed.demo.model.Codeape;
import com.gromed.demo.repository.CodeapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CodeapeService {

    @Autowired
    private CodeapeRepository codeapeRepository;

    public Optional<Codeape> getCodeape(String id) {
        return codeapeRepository.findById(id);
    }

    public List<Codeape> getAllCodeape() {
        return codeapeRepository.findAll();
    }

    public void deleteCodeape(String id) {
        codeapeRepository.deleteById(id);
    }

    public Codeape saveCodeape(Codeape id){
        return codeapeRepository.save(id);
    }
}
