package com.gromed.demo.controller;

import com.gromed.demo.service.CategorieetablissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/categorieetablissement")
public class CategorieetablissementController {

    @Autowired
    private CategorieetablissementService categorieetablissementService;



}
