package com.gromed.demo.controller;

import com.gromed.demo.service.ServicepublichospitalierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/servicepublichospitalier")
public class ServicepublichospitalierController {

    @Autowired
    private ServicepublichospitalierService servicepublichospitalierService;



}
