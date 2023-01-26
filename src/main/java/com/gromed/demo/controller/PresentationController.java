package com.gromed.demo.controller;

import com.gromed.demo.model.Medicament;
import com.gromed.demo.model.Presentation;
import com.gromed.demo.service.PresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/presentation")
public class PresentationController {

    @Autowired
    private PresentationService presentationService;

    /*
    @GetMapping("/list")
    @CrossOrigin()
    public List<Presentation> getAllPresentation() {
        return presentationService.getAllPresentation();
    }*/

    /*
    @GetMapping("/resultat")
    @CrossOrigin()
    public List<Presentation> getPresentationByRecherche() {
        return presentationService.getAllPresentation();
    }*/

}
