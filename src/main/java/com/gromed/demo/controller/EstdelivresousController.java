package com.gromed.demo.controller;

import com.gromed.demo.service.EstdelivresousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/estdelivresous")
public class EstdelivresousController {

    @Autowired
    private EstdelivresousService estdelivresousService;



}
