package com.gromed.demo.controller;

import com.gromed.demo.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/medicament")
public class MedicamentController {

    @Autowired
    private MedicamentService medicamentService;



}
