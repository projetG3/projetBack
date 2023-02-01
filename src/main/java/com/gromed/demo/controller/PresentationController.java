package com.gromed.demo.controller;

import com.gromed.demo.model.*;
import com.gromed.demo.service.PresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
@CrossOrigin()
@RequestMapping("/presentation")
public class PresentationController {

    @Autowired
    private PresentationService presentationService;

    @GetMapping("/{codeCIP7}")
    public ResponseEntity<Presentation> getPresentation(@PathVariable(value="codeCIP7") Long codeCIP7){
        Optional <Presentation> optionalPresentation = presentationService.getPresentation(codeCIP7);
        if(!optionalPresentation.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune présentation n'existe avec ce code");
        }
        return new ResponseEntity<>(optionalPresentation.get(), HttpStatus.OK);
     }

    @GetMapping("stock/{codeCIP7}")
    public Integer getStock(@PathVariable(value = "codeCIP7") Long codeCIP7){
        Optional <Presentation> presentation = presentationService.getPresentation(codeCIP7);
        if(!presentation.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune présentation n'existe avec ce code");
        }
        return presentation.get().getQuantitedispo();
    }


    @PostMapping("/resultat")
    public List<ResultatRecherche> getPrescriptionsBySearchResult(@RequestBody CritereRecherche critereRecherche) throws SQLException {
        return presentationService.getPresentationsByCriteria(critereRecherche);
    }

}
