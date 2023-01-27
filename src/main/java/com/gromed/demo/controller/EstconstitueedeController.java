package com.gromed.demo.controller;

import com.gromed.demo.model.Estconstitueede;
import com.gromed.demo.model.Presentation;
import com.gromed.demo.model.*;
import com.gromed.demo.service.CommandeService;
import com.gromed.demo.service.CompteService;
import com.gromed.demo.service.EstconstitueedeService;
import com.gromed.demo.service.PresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
@CrossOrigin()
@RequestMapping("/estconstitueede")
public class EstconstitueedeController {

    @Autowired
    private EstconstitueedeService estconstitueedeService;

    @Autowired
    private CompteService compteService;

    @Autowired
    private CommandeService commandeService;

    @Autowired
    private PresentationService presentationService;

    @GetMapping("/list")
    public List<Estconstitueede> getAllEstconstitueede() {
        return estconstitueedeService.getAllEstconstitueedes();
    }

    /*
   @GetMapping("/{idcompte}")
    public Estconstitueede getEstconstitueede(@PathVariable(value="idcompte") Long idcompte){
        Optional<Compte> compte = compteService.getCompte(idcompte);
        List<Commande> commandes = compte.get().getCommandes();
        List<Estconstitueede> estconstitueedes = new ArrayList<>();
        commandes.forEach(s->estconstitueedes.add((Estconstitueede) s.getEstconstitueedes()));
       for (Estconstitueede estconstitueede: estconstitueedes) {
           if(!estconstitueede.isPresent()){
               throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune présentation n'existe avec ce code");
           }
       }

        Presentation reelPresentation = optionalPresentation.get();
        return reelPresentation;
    }
*/



}
