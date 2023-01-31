package com.gromed.demo.controller;

import com.gromed.demo.service.AvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@CrossOrigin
@RequestMapping("/avis")
public class AvisController {

    @Autowired
    private AvisService avisService;


}
