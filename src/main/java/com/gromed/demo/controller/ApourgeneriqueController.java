package com.gromed.demo.controller;

import com.gromed.demo.service.ApourgeneriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/apourgenerique")
public class ApourgeneriqueController {

    @Autowired
    private ApourgeneriqueService apourgeneriqueService;



}
