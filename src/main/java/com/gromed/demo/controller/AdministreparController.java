package com.gromed.demo.controller;

import com.gromed.demo.service.AdministreparService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/administrepar")
public class AdministreparController {

    @Autowired
    private AdministreparService administreparService;



}
