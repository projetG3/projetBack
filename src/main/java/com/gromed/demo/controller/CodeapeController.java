package com.gromed.demo.controller;

import com.gromed.demo.service.CodeapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/codeape")
public class CodeapeController {

    @Autowired
    private CodeapeService codeapeService;


}
