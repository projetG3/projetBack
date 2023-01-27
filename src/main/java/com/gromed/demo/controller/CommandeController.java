package com.gromed.demo.controller;

import com.gromed.demo.model.AchatPresentation;
import com.gromed.demo.model.Commande;
import com.gromed.demo.model.Compte;
import com.gromed.demo.model.Utilisateur;
import com.gromed.demo.service.CommandeService;
import com.gromed.demo.service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Validated
@RestController
@CrossOrigin
@RequestMapping("/commande")
public class CommandeController {

    @Autowired
    private CommandeService commandeService;

}
