package com.gromed.demo.controller;

import com.gromed.demo.service.GeneriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/generique")
public class GeneriqueController {

    @Autowired
    private GeneriqueService generiqueService;


}
