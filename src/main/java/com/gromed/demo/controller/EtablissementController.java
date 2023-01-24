package com.gromed.demo.controller;

import com.gromed.demo.service.EtablissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/etablissement")
public class EtablissementController {

    @Autowired
    private EtablissementService etablissementService;


}
