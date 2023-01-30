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

        //si l'objet n'est pas complet alors on emet une erreur
        if (achatPresentation == null || achatPresentation.getQuantiteCommande() == 0 || achatPresentation.getProduit() == null || achatPresentation.getIdCompte() == null) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Il manque le numéro du produit souhaité ou la quantité souhaitée ou votre identifiant");
        }

        //Si on ne trouve pas d'utilisateur avec cet ID alors on emet une erreur
        Optional<Compte> optionalCompte = compteService.getCompte(achatPresentation.getIdCompte());
        if (!optionalCompte.isPresent()) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "L'identifiant de l'utilisateur est incorrect");
        }
        Compte reelCompte = optionalCompte.get();

        //on emet une erreur si on ne trouve pas la présentation coorespondante
        Optional<Presentation> optionalPresentation = presentationService.getPresentation(achatPresentation.getProduit());
        if(!optionalPresentation.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La référence au produit n'est pas trouvée");
        }

        //on veut savoir s'il y a une commande en cours
        Commande commandeEnCours = compteService.getCommandeEnCours(reelCompte.getId());

        //si il n'y a pas de commande en cours alors :
        if(commandeEnCours.getId() == null){
            //on créer la commande
            commandeEnCours = compteService.createCommande(reelCompte);
        }
        return compteService.addProduct(commandeEnCours, optionalPresentation.get(), achatPresentation.getQuantiteCommande());
    }

    @PostMapping("/updateQuantite")
    public Commande updateQuantiteProduit(@RequestBody AchatPresentation achatPresentation) throws SQLException {
        //si l'objet n'est pas complet alors on emet une erreur
        if (achatPresentation == null || achatPresentation.getQuantiteCommande() == 0 || achatPresentation.getProduit() == null || achatPresentation.getIdCompte() == null) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Il manque le numéro du produit souhaité ou la quantité souhaitée ou votre identifiant");
        }

        //Si on ne trouve pas d'utilisateur avec cet ID alors on emet une erreur
        Optional<Compte> optionalCompte = compteService.getCompte(achatPresentation.getIdCompte());
        if (!optionalCompte.isPresent()) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "L'identifiant de l'utilisateur est incorrect");
        }
        Compte reelCompte = optionalCompte.get();

        //on emet une erreur si on ne trouve pas la présentation coorespondante
        Optional<Presentation> optionalPresentation = presentationService.getPresentation(achatPresentation.getProduit());
        if(!optionalPresentation.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La référence au produit n'est pas trouvée");
        }

        //on veut savoir s'il y a une commande en cours
        Commande commandeEnCours = compteService.getCommandeEnCours(reelCompte.getId());

        //si il y a un commande en cours alors :
        if(commandeEnCours.getId() != null){
            //on récupère la liste des produits qui sont dans la panier
            List<Estconstitueede> estconstitueedeList = commandeEnCours.getEstconstitueedes();
            //puis on parcours cette liste
            for(int i = 0; i < estconstitueedeList.size(); i++){
                //si le produit courant est le même que le produit dont l'utilisateur souhaite modifier la quantité alors
                if(estconstitueedeList.get(i).getPresentation().getId() == achatPresentation.getProduit()){
                    //si l'utilisateur ne veut plus le produit alors
                    if(achatPresentation.getQuantiteCommande() == 0){
                        estconstitueedeService.deleteEstconstitueede(estconstitueedeList.get(i).getId());
                    }
                    else{ //sinon l'utilisateur change simplement la quantité souhaitée
                        //alors on modifie la quantité
                        estconstitueedeList.get(i).setQuantite(achatPresentation.getQuantiteCommande());
                        //puis on enregistre la modification
                        estconstitueedeService.saveEstconstitueede(estconstitueedeList.get(i));
                    }
                    return commandeEnCours;
                }
            }
        }
        //dans le cas ou nous n'avons pas trouvé le produit en question dans le panier alors on emet une erreur http
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nous n'avons pas pû trouver votre commande ou ce produit n'est pas dans votre commande");
    }

    @PostMapping("/getCommandeType")
    public List<Commande> getCommandeType(@RequestBody IdCompte idCompte) throws SQLException {
        //Si on ne trouve pas d'utilisateur avec cet ID alors on emet une erreur
        Optional<Compte> optionalCompte = compteService.getCompte(idCompte.getIdCompte());
        if (!optionalCompte.isPresent()) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "L'identifiant de l'utilisateur est incorrect");
        }
        Compte reelCompte = optionalCompte.get();

        return compteService.getCommandeType(reelCompte);
    }

}
