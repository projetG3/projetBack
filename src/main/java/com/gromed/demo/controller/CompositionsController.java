package com.gromed.demo.controller;

import com.gromed.demo.model.Composition;
import com.gromed.demo.service.CompositionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Validated
@RestController
@RequestMapping("/compositions")
public class CompositionsController {

    @Autowired
    private CompositionsService compositionsService;

    @CrossOrigin()
    @GetMapping("/principeactif")
    public List<String> getAllPrincipesActifs() throws SQLException {
        return compositionsService.getAllPrincipesActifs();
    }

}
