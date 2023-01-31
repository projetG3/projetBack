package com.gromed.demo.controller;

import com.gromed.demo.model.VoieAdministration;
import com.gromed.demo.service.VoieAdministrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/voieadministration")
public class VoieAdministrationController {

    @Autowired
    private VoieAdministrationService voieadministrationService;

    @CrossOrigin()
    @GetMapping("/list")
    public List<VoieAdministration> getAllVoieAdministration(){
        return voieadministrationService.getAllVoieAdministration();
    }

}