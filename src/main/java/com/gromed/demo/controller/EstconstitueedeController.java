package com.gromed.demo.controller;

import com.gromed.demo.model.Estconstitueede;
import com.gromed.demo.model.*;
import com.gromed.demo.service.CompteService;
import com.gromed.demo.service.EstconstitueedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.List;


@Validated
@RestController
@CrossOrigin()
@RequestMapping("/estconstitueede")
public class EstconstitueedeController {

    @Autowired
    private EstconstitueedeService estconstitueedeService;

    @Autowired
    private CompteService compteService;

    @GetMapping("/list")
    public List<Estconstitueede> getAllEstconstitueede() {
        return estconstitueedeService.getAllEstconstitueedes();
    }

   @GetMapping("/{idcompte}")
    public List<Estconstitueede> getEstconstitueede(@PathVariable(value="idcompte") Long idcompte) throws SQLException {
       Commande commande = compteService.getCommandeEnCours(idcompte);
       if(commande.getId() == null){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune commande en cours n'existe avec cet idcompte");
       }
        List<Estconstitueede> estconstitueedes = commande.getEstconstitueedes();
       if(estconstitueedes.isEmpty()){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune estconstitueede n'existe avec cet idcompte");
       }
       return estconstitueedes;
    }
}
