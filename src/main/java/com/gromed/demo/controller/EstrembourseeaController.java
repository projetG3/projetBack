package com.gromed.demo.controller;

import com.gromed.demo.service.EstrembourseeaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/estrembourseea")
public class EstrembourseeaController {

    @Autowired
    private EstrembourseeaService estrembourseeaService;


}
