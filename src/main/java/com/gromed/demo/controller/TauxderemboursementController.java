package com.gromed.demo.controller;

import com.gromed.demo.service.TauxderemboursementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/tauxderemboursement")
public class TauxderemboursementController {

    @Autowired
    private TauxderemboursementService tauxderemboursementService;



}