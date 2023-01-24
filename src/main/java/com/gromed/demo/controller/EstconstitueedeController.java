package com.gromed.demo.controller;

import com.gromed.demo.service.EstconstitueedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/estconstitueede")
public class EstconstitueedeController {

    @Autowired
    private EstconstitueedeService estconstitueedeService;



}
