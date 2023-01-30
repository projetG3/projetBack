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



    @GetMapping("/{codecis}")
    @CrossOrigin()
    public Medicament getMedicament(@PathVariable(value="codecis") Long codecis){

        System.out.println("METHODE GETMEDICAMENT");

        if(codecis == null) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Vous n'avez pas indiqué le code du médicament");
        }
        Optional<Medicament> optionalMedicament = medicamentService.getMedicament(codecis);
        if(!optionalMedicament.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ce medicament n'existe pas");
        }
        return optionalMedicament.get();
    }


}
