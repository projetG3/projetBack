package com.gromed.demo.Controller;

import com.gromed.demo.controller.CommandeController;
import com.gromed.demo.model.*;
import com.gromed.demo.service.CommandeService;
import com.gromed.demo.service.CompteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertNotEquals;

@SpringBootTest
class CommandeControllerTest {

    @Autowired
    private CommandeController commandeController;
    @Autowired
    private CommandeService commandeService;
    @Autowired
    private CompteService compteService;

    @Test
    void addProduct() throws SQLException {
        AchatPresentation achatPresentation = new AchatPresentation();
        achatPresentation.setIdCompte(5L);
        achatPresentation.setQuantiteCommande(1);
        achatPresentation.setProduit(3729641L);
        Commande commande = commandeController.addProduct(achatPresentation);
        List<Estconstitueede> estconstitueedes = commande.getEstconstitueedes();
        Estconstitueede estconstitueede = new Estconstitueede();
        for (Estconstitueede e: estconstitueedes) {
            if(e.getPresentation().getCodecis().equals(achatPresentation.getProduit())){
                estconstitueede = e;
            }
        }
        Boolean res = estconstitueedes.contains(estconstitueede);
        assertNotEquals("0", res, "null");
    }

    @Test
    void addProductErrorPresentation() throws SQLException {
        try {
            AchatPresentation achatPresentation = new AchatPresentation();
            achatPresentation.setIdCompte(5L);
            achatPresentation.setQuantiteCommande(1);
            Commande commande = commandeController.addProduct(achatPresentation);
        } catch (ResponseStatusException ex) {
            assertEquals("0","Il manque le numéro du produit souhaité ou la quantité souhaitée ou votre identifiant", ex.getReason());
        }
    }

    @Test
    void addProductErrorCompte() throws SQLException {
        try {
            AchatPresentation achatPresentation = new AchatPresentation();
            achatPresentation.setIdCompte(1L);
            achatPresentation.setProduit(3729641L);
            achatPresentation.setQuantiteCommande(1);
            Commande commande = commandeController.addProduct(achatPresentation);
        } catch (ResponseStatusException ex) {
            assertEquals("0","L'identifiant de l'utilisateur n'est pas correct",ex.getReason());
        }
    }

    @Test
    void addProductErrorPresentationCompte() throws SQLException {
        try {
            AchatPresentation achatPresentation = new AchatPresentation();
            achatPresentation.setIdCompte(5L);
            achatPresentation.setProduit(31L);
            achatPresentation.setQuantiteCommande(1);
            Commande commande = commandeController.addProduct(achatPresentation);
        } catch (ResponseStatusException ex) {
            assertEquals("0","La référence au produit n'est pas trouvée",ex.getReason());
        }
    }

    @Test
    void getCommandeTypeErrorCompte() throws SQLException {
        try {
            IdCompte idCompte = new IdCompte();
            idCompte.setIdCompte(1L);
            commandeController.getCommandeType(idCompte);
        }catch (ResponseStatusException ex){
            assertEquals("0","L'identifiant de l'utilisateur n'est pas correct", ex.getReason());
        }
    }

    @Test
    void validerErrorPresentationCompte(){
        try {
            Commande commande = commandeService.getAllCommande().get(0);
            Compte compte = compteService.getAllComptes().get(0);
            commandeController.valider(compte.getId(), commande.getId());
        } catch (ResponseStatusException ex) {
            assertEquals("0","le compte ne correspond pas a la commande", ex.getReason());
        }
    }

    @Test
    void validerErrorPresentation(){
        try {
            Commande commande = commandeService.getAllCommande().get(0);
            commandeController.valider(commande.getCompte().getId(), commande.getId()+1);
        } catch (ResponseStatusException ex) {
            assertEquals("0","il n'y a pas de commande avec ce code", ex.getReason());
        }
    }

    /*@Test
    void validerErrorCompte() {
        try {
            Commande commande = commandeService.getAllCommande().get(0);
            commandeController.valider(1L, commande.getId());
        } catch (ResponseStatusException ex) {
            assertThat("L'identifiant de l'utilisateur n'est pas correct").isEqualTo(ex.getReason());
        }
    }

     */

    @Test
    void validerforceErrorPresentationCompte(){
        try {
            Commande commande = commandeService.getAllCommande().get(0);
            Compte compte = compteService.getAllComptes().get(0);
            commandeController.validerForce(compte.getId(), commande.getId());
        } catch (ResponseStatusException ex) {
            assertEquals("0","le compte ne correspond pas a la commande", ex.getReason());
        }
    }

    @Test
    void validerforceErrorPresentation(){
        try {
            Commande commande = commandeService.getAllCommande().get(0);
            commandeController.validerForce(commande.getCompte().getId(), commande.getId()+1);
        } catch (ResponseStatusException ex) {
            assertEquals("0","il n'y a pas de commande avec ce code", ex.getReason());
        }
    }

    /*@Test
    void validerforceErrorCompte() {
        try {
            Commande commande = commandeService.getAllCommande().get(0);
            commandeController.validerForce(1L, commande.getId());
        } catch (ResponseStatusException ex) {
            assertThat("L'identifiant de l'utilisateur n'est pas correct").isEqualTo(ex.getReason());
        }
    }

    @Test
    void validerForce(){
        Commande commande = commandeService.getAllCommande().get(0);
        ResponseEntity<Boolean> valider = commandeController.validerForce(commande.getCompte().getId(), commande.getId());
        assertThat(valider).isEqualTo(true);
    }

     */

    @Test
    void createCommandeTypeErrorId() {
        try {
            Commande commande = commandeService.getAllCommande().get(0);
            CommandeType commandeType = new CommandeType();
            commandeType.setCommande(commande.getId());
            commandeType.setCompte(commande.getCompte().getId());
            commandeType.setNom("Retock");
            commandeController.createCommandeType(commandeType);
        } catch (ResponseStatusException ex) {
            assertEquals("0","L'identifiant renseigné ne correspond pas à l'identifiant qui a créé la commande",ex.getReason());
        }
    }

    @Test
    void createCommandeTypeErrorCompte() {
        try {
            Commande commande = commandeService.getAllCommande().get(0);
            Compte compte = compteService.getAllComptes().get(0);
            CommandeType commandeType = new CommandeType();
            commandeType.setCommande(commande.getId());
            commandeType.setCompte(1L);
            commandeType.setNom("Retock");
            commandeController.createCommandeType(commandeType);
        } catch (ResponseStatusException ex) {
            assertEquals("0","L'identifiant de l'utilisateur n'est pas correct",ex.getReason());
        }
    }

    @Test
    void createCommandeTypeErrorNom() {
        try {
            Commande commande = commandeService.getAllCommande().get(0);
            Compte compte = compteService.getAllComptes().get(0);
            CommandeType commandeType = new CommandeType();
            commandeType.setCommande(commande.getId());
            commandeType.setCompte(compte.getId());
            commandeController.createCommandeType(commandeType);
        } catch (ResponseStatusException ex) {
            assertEquals("0","Il manque le nom souhaité pour la commande type ou l'identifiant du compte ou l'identifiant de la commande",ex.getReason());
        }
    }

   /* @Test
    void ajouterCommandeTypeErrorId() throws SQLException {
        try {
            Commande commande = commandeService.getAllCommande().get(0);
            commandeController.ajouterCommandeType(1L, commande.getId());
        } catch (ResponseStatusException ex) {
            assertThat("il n'y a pas de commande avec ce code").isEqualTo(ex.getReason());
        }
    }

    @Test
    void ajouterCommandeTypeErrorCompte() {
        try {
            Commande commande = commandeService.getAllCommande().get(0);
            Compte compte = compteService.getAllComptes().get(0);
            CommandeType commandeType = new CommandeType();
            commandeType.setCommande(commande.getId());
            commandeType.setCompte(1L);
            commandeType.setNom("Retock");
            commandeController.createCommandeType(commandeType);
        } catch (ResponseStatusException ex) {
            assertThat("L'identifiant de l'utilisateur n'est pas correct").isEqualTo(ex.getReason());
        }
    }
    */
}