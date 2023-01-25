package com.gromed.demo.service;

import com.gromed.demo.model.TypeProcedure;
import com.gromed.demo.repository.TypeProcedureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeProcedureService {

    @Autowired
    TypeProcedureRepository typeProcedureRepository;

    public Optional<TypeProcedure> getTypeprocedure(String id) {
        return typeProcedureRepository.findById(id);
    }

    public List<TypeProcedure> getAllTypeprocedure() {
        return typeProcedureRepository.findAll();
    }

    public void deleteTypeprocedure(String id) {
        typeProcedureRepository.deleteById(id);
    }

    public TypeProcedure save(TypeProcedure id){
        return typeProcedureRepository.save(id);
    }
}
