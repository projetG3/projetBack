package com.gromed.demo.controller;

import com.gromed.demo.service.InformeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/informe")
public class InformeController {

    @Autowired
    private InformeService informeService;



}
