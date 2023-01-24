package com.gromed.demo.controller;

import com.gromed.demo.service.TitulaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/titulaire")
public class TitulaireController {

    @Autowired
    private TitulaireService titulaireService;



}
