package com.gromed.demo.service;

import com.gromed.demo.model.Conditionsmedicamenteuse;
import com.gromed.demo.repository.ConditionsmedicamenteuseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConditionsmedicamenteuseService {

    @Autowired
    private ConditionsmedicamenteuseRepository conditionsmedicamenteuseRepository;

    public Optional<Conditionsmedicamenteuse> getConditionsmedicamenteuse(String id) {
        return conditionsmedicamenteuseRepository.findById(id);
    }

    public List<Conditionsmedicamenteuse> getAllConditionsmedicamenteuses() {
        return conditionsmedicamenteuseRepository.findAll();
    }

    public void deleteConditionsmedicamenteuse(String id) {
        conditionsmedicamenteuseRepository.deleteById(id);
    }

    public Conditionsmedicamenteuse saveConditionsmedicamenteuse(Conditionsmedicamenteuse id){
        return conditionsmedicamenteuseRepository.save(id);
    }
}
