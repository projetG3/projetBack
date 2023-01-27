package com.gromed.demo.controller;

import com.gromed.demo.model.*;
import com.gromed.demo.service.AvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Validated
@RestController
@CrossOrigin
@RequestMapping("/avis")
public class AvisController {

    @Autowired
    private AvisService avisService;


}
