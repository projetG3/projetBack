package com.gromed.demo.controller;

import com.gromed.demo.model.Informationsimportante;
import com.gromed.demo.model.Informe;
import com.gromed.demo.model.*;
import com.gromed.demo.service.PresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
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

    /*
    @GetMapping("/list")
    public List<Presentation> getAllPresentation() {
        return presentationService.getAllPresentation();
    }
    */

    @GetMapping("/{codeCIP7}")
    public Presentation getPresentation(@PathVariable(value="codeCIP7") Long codeCIP7){
        Optional <Presentation> optionalPresentation = presentationService.getPresentation(codeCIP7);
        if(!optionalPresentation.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune présentation n'existe avec ce code");
        }
        Presentation reelPresentation = optionalPresentation.get();
        return reelPresentation;
    }


    @PostMapping("/resultat")
    public List<Presentation> getPrescriptionsBySearchResult(@RequestBody CritereRecherche critereRecherche) throws SQLException {
        return presentationService.getPresentationsByCriteria(critereRecherche);
    }

}
