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

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Validated
@RestController
@CrossOrigin
@RequestMapping("/commande")
public class CommandeController {

    @Autowired
    private EstconstitueedeService estconstitueedeService;

    @Autowired
    private CompteService compteService;

    @Autowired
    private CommandeService commandeService;

    @Autowired
    private PresentationService presentationService;

    @GetMapping("/list")
    public List<Commande> getAllCommande() {
        return commandeService.getAllCommande();
    }

    @PostMapping("/create")
    public void createCommande(@RequestBody AchatPresentation achatPresentation) throws SQLException {
        if (achatPresentation == null || achatPresentation.getQuantiteCommande() == 0 || achatPresentation.getProduit() == null || achatPresentation.getIdCompte() == null) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Il manque le numéro du produit souhaité ou la quantité souhaitée ou votre identifiant");
        }

        Commande newCommande = new Commande();
        Optional<Compte> optionalCompte = compteService.getCompte(achatPresentation.getIdCompte());
        if (!optionalCompte.isPresent()) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "L'identifiant de l'utilisateur est incorrect");
        }
        Compte reelCompte = optionalCompte.get();
        Commande commandeEnCours = compteService.getCommandeEnCours(reelCompte.getId());
        System.out.println("///////////////////////////////////////////////////////");
        System.out.println(commandeEnCours.getId());
        if(commandeEnCours.getId() != null){
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Il n'est pas possible de créer un panier car vous avez déjà un panier en cours");
        }
        commandeEnCours.setStatus("en cours");
        Estconstitueede estconstitueede = new Estconstitueede();
        estconstitueede.setTerminer(false);
        estconstitueede.setQuantite(achatPresentation.getQuantiteCommande());
        Optional<Presentation> optionalPresentation = presentationService.getPresentation(achatPresentation.getProduit());
        if(!optionalPresentation.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La référence au produit n'est pas trouvée");
        }
        estconstitueede.setPresentation(optionalPresentation.get());
        commandeEnCours.addEstConstitueeDe(estconstitueede);

        commandeEnCours = commandeService.saveCommande(commandeEnCours);
        //commandeEnCours.set
        reelCompte.addCommande(commandeEnCours);

    }
}
