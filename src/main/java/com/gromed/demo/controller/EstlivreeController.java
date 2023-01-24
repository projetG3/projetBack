package com.gromed.demo.controller;

import com.gromed.demo.service.EstlivreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/estlivree")
public class EstlivreeController {

    @Autowired
    private EstlivreeService estlivreeService;



}
