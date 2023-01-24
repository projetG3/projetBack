package com.gromed.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class InformationsimportantesService {

    @Autowired
    private InformationsimportantesRepository informationsimportantesRepository;

    public String save(InformationsimportantesVO vO) {
        Informationsimportantes bean = new Informationsimportantes();
        BeanUtils.copyProperties(vO, bean);
        bean = informationsimportantesRepository.save(bean);
        return bean.getDatedebutinfo();
    }

    public void delete(String id) {
        informationsimportantesRepository.deleteById(id);
    }

    public void update(String id, InformationsimportantesUpdateVO vO) {
        Informationsimportantes bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        informationsimportantesRepository.save(bean);
    }

    public InformationsimportantesDTO getById(String id) {
        Informationsimportantes original = requireOne(id);
        return toDTO(original);
    }

    public Page<InformationsimportantesDTO> query(InformationsimportantesQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private InformationsimportantesDTO toDTO(Informationsimportantes original) {
        InformationsimportantesDTO bean = new InformationsimportantesDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Informationsimportantes requireOne(String id) {
        return informationsimportantesRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
