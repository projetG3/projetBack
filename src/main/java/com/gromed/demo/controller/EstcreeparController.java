package com.gromed.demo.controller;

import com.gromed.demo.service.EstcreeparService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/estcreepar")
public class EstcreeparController {

    @Autowired
    private EstcreeparService estcreeparService;



}
