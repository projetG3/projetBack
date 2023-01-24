package com.gromed.demo.controller;

import com.gromed.demo.service.ConditionsmedicamenteuseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/conditionsmedicamenteuse")
public class ConditionsmedicamenteuseController {

    @Autowired
    private ConditionsmedicamenteuseService conditionsmedicamenteuseService;


}
