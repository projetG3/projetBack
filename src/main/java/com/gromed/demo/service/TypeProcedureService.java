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
    private TypeProcedureRepository typeProcedureRepository;

    public Optional<TypeProcedure> getGenerique(String id) {
        return typeProcedureRepository.findById(id);
    }

    public List<TypeProcedure> getAllGeneriques() {
        return typeProcedureRepository.findAll();
    }

    public void deleteGenerique(String id) {
        typeProcedureRepository.deleteById(id);
    }

    public TypeProcedure saveGenerique(TypeProcedure id){
        return typeProcedureRepository.save(id);
    }
}
