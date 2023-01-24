package com.gromed.demo.controller;

import com.gromed.demo.service.VoieAdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/voieadministration")
public class VoieAdministrationController {

    @Autowired
    private VoieAdministrationService voieadministrationService;



}