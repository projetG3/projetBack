package com.gromed.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class GeneriqueService {

    @Autowired
    private GeneriqueRepository generiqueRepository;

    public String save(GeneriqueVO vO) {
        Generique bean = new Generique();
        BeanUtils.copyProperties(vO, bean);
        bean = generiqueRepository.save(bean);
        return bean.getIdgenerique();
    }

    public void delete(String id) {
        generiqueRepository.deleteById(id);
    }

    public void update(String id, GeneriqueUpdateVO vO) {
        Generique bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        generiqueRepository.save(bean);
    }

    public GeneriqueDTO getById(String id) {
        Generique original = requireOne(id);
        return toDTO(original);
    }

    public Page<GeneriqueDTO> query(GeneriqueQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private GeneriqueDTO toDTO(Generique original) {
        GeneriqueDTO bean = new GeneriqueDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Generique requireOne(String id) {
        return generiqueRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
