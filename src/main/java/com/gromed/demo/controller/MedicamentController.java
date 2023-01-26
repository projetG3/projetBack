package com.gromed.demo.controller;

import com.gromed.demo.model.*;
import com.gromed.demo.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@Validated
@RestController
@CrossOrigin()
@RequestMapping("/medicament")
public class MedicamentController {

    @Autowired
    private MedicamentService medicamentService;


    /*
    @PostMapping("/recherche")
    @CrossOrigin()
    public Compte getMedicamentByRecherche(@RequestBody Utilisateur user){
        if(user == null || user.getId() == null || user.getPassword() == null) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Vous n'avez pas indiqué votre mot de passe ou identifiant");
        }
        Optional<Compte> compte = compteService.getCompte(user.getId());
        if(!compte.isPresent()) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Cette ID n'existe pas");
        }
        if(!compte.get().getMotDePasse().equals(user.getPassword())){
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Mot de passe incorrect");
        }
        return compte.get();
    }
    */

}
