package com.gromed.demo.service;

import com.gromed.demo.model.Presentation;
import com.gromed.demo.repository.PresentationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PresentationService {

    @Autowired
    private PresentationRepository presentationRepository;

    public Optional<Presentation> getPresentation(final Long id) {
        return presentationRepository.findById(id);
    }

    public List<Presentation> getAllPresentation() {
        return presentationRepository.findAll();
    }

    public void deletePresentation(final Long id) {
        presentationRepository.deleteById(id);
    }

    public Presentation savePresentation(Presentation presentation){
        return presentationRepository.save(presentation);
    }
}
