package com.gromed.demo.controller;

import com.gromed.demo.service.CompositionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/compositions")
public class CompositionsController {

    @Autowired
    private CompositionsService compositionsService;



}
