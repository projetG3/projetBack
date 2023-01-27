package com.gromed.demo.controller;

import com.gromed.demo.model.Commande;
import com.gromed.demo.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@CrossOrigin
@RequestMapping("/commande")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

    @GetMapping("/list")
    public List<Commande> getAllCommande() {
        return commandeService.getAllCommande();
    }
}
