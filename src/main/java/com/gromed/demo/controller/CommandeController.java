package com.gromed.demo.controller;

import com.gromed.demo.model.*;
import com.gromed.demo.service.*;
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

    @PostMapping("/addProduct")
    public Commande addProduct(@RequestBody AchatPresentation achatPresentation) throws SQLException {

        //si l'objet n'est pas complet alors on émet une erreur
        if (achatPresentation == null || achatPresentation.getQuantiteCommande() == 0 || achatPresentation.getProduit() == null || achatPresentation.getIdCompte() == null) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Il manque le numéro du produit souhaité ou la quantité souhaitée ou votre identifiant");
        }

        //Si on ne trouve pas d'utilisateur avec cet ID alors on émet une erreur
        Optional<Compte> optionalCompte = compteService.getCompte(achatPresentation.getIdCompte());
        if (!optionalCompte.isPresent()) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "L'identifiant de l'utilisateur est incorrect");
        }
        Compte reelCompte = optionalCompte.get();

        //on émet une erreur si on ne trouve pas la présentation correspondante
        Optional<Presentation> optionalPresentation = presentationService.getPresentation(achatPresentation.getProduit());
        if(!optionalPresentation.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La référence au produit n'est pas trouvée");
        }

        //on veut savoir s'il y a une commande en cours
        Commande commandeEnCours = compteService.getCommandeEnCours(reelCompte.getId());

        //si il n'y a pas de commande en cours alors :
        if(commandeEnCours.getId() == null){
            //on crée la commande
            commandeEnCours = compteService.createCommande(reelCompte);
        }
        return compteService.addProduct(commandeEnCours, optionalPresentation.get(), achatPresentation.getQuantiteCommande());
    }


    @PostMapping("/commandecourante")
    public Commande getCommandeCourante(@RequestBody Long idUser) throws SQLException {
        //Si on ne trouve pas d'utilisateur avec cet ID alors on émet une erreur
        Optional<Compte> optionalCompte = compteService.getCompte(idUser);
        if (!optionalCompte.isPresent()) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "L'identifiant de l'utilisateur est incorrect");
        }
        Compte reelCompte = optionalCompte.get();

        //on veut savoir s'il y a une commande en cours
        Commande commandeEnCours = compteService.getCommandeEnCours(reelCompte.getId());

        return commandeEnCours;
    }

    @PostMapping("/getCommandeType")
    public List<Commande> getCommandeType(@RequestBody IdCompte idCompte) throws SQLException {
        //Si on ne trouve pas d'utilisateur avec cet ID alors on émet une erreur
        Optional<Compte> optionalCompte = compteService.getCompte(idCompte.getIdCompte());
        if (!optionalCompte.isPresent()) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "L'identifiant de l'utilisateur est incorrect");
        }
        Compte reelCompte = optionalCompte.get();

        return compteService.getCommandeType(reelCompte);
    }


    @GetMapping("/valider/{idcompte}/{idcommande}")
    public List<Estconstitueede> getValider(@PathVariable(value = "idcompte") Long idcompte,
                                            @PathVariable(value = "idcommande") Long idcommande){
        Optional<Commande> commande = commandeService.getCommande(idcommande);
        Optional<Compte> compte = compteService.getCompte(idcompte);
        if (!commande.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "il n'y a pas de commande avec ce code");
        }
        if (!compte.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "il n'y a pas de compte avec ce code");
        }
        if (!commande.get().getCompte().getId().equals(compte.get().getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "le compte ne correspond pas a la commande");
        }

        return commandeService.getStock(commande);
    }
}
