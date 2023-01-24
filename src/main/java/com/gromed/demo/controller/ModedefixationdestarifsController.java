package com.gromed.demo.controller;

import com.gromed.demo.service.ModedefixationdestarifsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/modedefixationdestarifs")
public class ModedefixationdestarifsController {

    @Autowired
    private ModedefixationdestarifsService modedefixationdestarifsService;



}
