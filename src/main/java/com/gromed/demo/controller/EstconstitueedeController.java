package com.gromed.demo.controller;

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

import java.util.Optional;

@Validated
@RestController
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

    @PostMapping("/create")
    public Estconstitueede createCommande(@RequestBody AchatPresentation achatPresentation) {
        if (achatPresentation == null || achatPresentation.getQuantiteCommande() == 0 || achatPresentation.getProduit() == null || achatPresentation.getIdCompte() == null) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Il manque le numéro du produit souhaité ou la quantité souhaitée ou votre identifiant");
        }

        //////////////////////////////////////
        Commande newCommande = new Commande();
        Optional<Compte> optionalCompte = compteService.getCompte(achatPresentation.getIdCompte());
        if (!optionalCompte.isPresent()) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "L'identifiant de l'utilisateur est incorrect");
        }
        Compte reelCompte = optionalCompte.get();
        newCommande.setCompte(reelCompte);
        newCommande = commandeService.saveCommande(newCommande);
        ///////////////////////////////////
        Estconstitueede newEstConstitueede = new Estconstitueede();
        newEstConstitueede.setCommande(newCommande);

        newEstConstitueede.setQuantite(achatPresentation.getQuantiteCommande());

        EstconstitueedeId newEstConsitueeDeId = new EstconstitueedeId();
        newEstConsitueeDeId.setIdcommande(newCommande.getId());
        newEstConsitueeDeId.setCodecip7(achatPresentation.getProduit());
        newEstConstitueede.setId(newEstConsitueeDeId);

        Optional <Presentation> optionalPresentation = presentationService.getPresentation(achatPresentation.getProduit());
        if(!optionalPresentation.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produit non trouvé");
        }
        Presentation reelPresentation = optionalPresentation.get();
        newEstConstitueede.setPresentation(reelPresentation);
        newEstConstitueede.setTerminer(false);

        newEstConstitueede = estconstitueedeService.saveEstconstitueede(newEstConstitueede);
        return newEstConstitueede;
    }


}
