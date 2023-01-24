package com.gromed.demo.controller;

import com.gromed.demo.service.InformationsimportanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/informationsimportantes")
public class InformationsimportantesController {

    @Autowired
    private InformationsimportanteService informationsimportantesService;



}
