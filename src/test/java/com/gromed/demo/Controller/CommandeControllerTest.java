package com.gromed.demo.Controller;

import com.gromed.demo.controller.CommandeController;
import com.gromed.demo.model.*;
import com.gromed.demo.service.CommandeService;
import com.gromed.demo.service.CompteService;
import com.gromed.demo.service.PresentationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CommandeControllerTest {
    @Mock
    private CompteService compteService;
    @Mock
    private PresentationService presentationService;
    @Mock
    private CommandeService commandeService;
    @InjectMocks
    private CommandeController controller;

    @Test
    public void testAddProduct() throws SQLException {
        AchatPresentation achatPresentation = new AchatPresentation();
        achatPresentation.setIdCompte(1L);
        achatPresentation.setProduit(2L);
        achatPresentation.setQuantiteCommande(3);

        Compte compte = new Compte();
        compte.setId(1L);

        when(compteService.getCompte(1L)).thenReturn(Optional.of(compte));
        when(compteService.getCommandeEnCours(1L)).thenReturn(null);
        when(compteService.createCommande(compte)).thenReturn(new Commande());

        Presentation presentation = new Presentation();
        presentation.setId(2L);

        when(presentationService.getPresentation(2L)).thenReturn(Optional.of(presentation));

        ResponseEntity<Commande> response = controller.addProduct(achatPresentation);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testAddProductErrorPresentation() throws SQLException {
        AchatPresentation achatPresentation = new AchatPresentation();
        achatPresentation.setQuantiteCommande(0);
        achatPresentation.setProduit(null);
        achatPresentation.setIdCompte(null);

        try {
            controller.addProduct(achatPresentation);
            fail("Exception");
        } catch (ResponseStatusException ex) {
            assertEquals("Il manque le numéro du produit souhaité ou la quantité souhaitée ou votre identifiant", ex.getReason());
        }
    }

    @Test
    public void testAddProductErrorCompte() throws SQLException {
        AchatPresentation achatPresentation = new AchatPresentation();
        achatPresentation.setQuantiteCommande(2);
        achatPresentation.setProduit(1L);
        achatPresentation.setIdCompte(1L);

        CompteService compteService = mock(CompteService.class);
        try {
            controller.addProduct(achatPresentation);
            fail("Exception");
        } catch (ResponseStatusException ex) {
            assertEquals("L'identifiant de l'utilisateur n'est pas correct", ex.getReason());
        }
    }
    @Test
    public void getCommandeTypeErrorCompte() throws SQLException {
        CompteService compteService = mock(CompteService.class);
        try {
            controller.getCommandeType(1L);
            fail("Exception");
        } catch (ResponseStatusException ex) {
            assertEquals("L'identifiant de l'utilisateur n'est pas correct", ex.getReason());
        }
    }

    @Test
    public void validerErrorPresentation(){
        Commande commande = new Commande();
        commande.setNom("commande");
        commande.setStatusfacture(true);
        commande.setDatefacture(LocalDate.now());
        commande.setMontanttotal("12,23€");
        commande.setStatus("terminer");
        commande.setId(12L);
        commande.setDateheurecommande(LocalDateTime.now());
        commande.setEstconstitueede(new ArrayList<>());

        PresentationService presentationService = mock(PresentationService.class);
        try {
            controller.valider(1L, commande.getId());
            fail("Exception");
        } catch (ResponseStatusException ex) {
            assertEquals("il n'y a pas de commande avec ce code", ex.getReason());
        }
    }


    @Test
    public void validerForceErrorPresentation(){
        Commande commande = new Commande();
        commande.setNom("commande");
        commande.setStatusfacture(true);
        commande.setDatefacture(LocalDate.now());
        commande.setMontanttotal("12,23€");
        commande.setStatus("terminer");
        commande.setId(12L);
        commande.setDateheurecommande(LocalDateTime.now());
        commande.setEstconstitueede(new ArrayList<>());

        PresentationService presentationService = mock(PresentationService.class);
        try {
            controller.validerForce(1L, commande.getId());
            fail("Exception");
        } catch (ResponseStatusException ex) {
            assertEquals("il n'y a pas de commande avec ce code", ex.getReason());
        }
    }

    @Test
    public void testCreateCommandeTypeErrorCompte(){
        CommandeType commandeType = new CommandeType();
        commandeType.setNom("commande");
        commandeType.setCommande(2L);
        commandeType.setCompte(3L);

        Compte compte = new Compte();
        compte.setId(3L);

        try {
            controller.createCommandeType(commandeType);
            fail("Exception");
        } catch (ResponseStatusException ex) {
            assertEquals("L'identifiant de l'utilisateur n'est pas correct", ex.getReason());
        }
    }

    @Test
    public void testCreateCommandeTypeErrorPresentation() throws SQLException {
        CommandeType commandeType = new CommandeType();
        commandeType.setNom("commande");
        commandeType.setCommande(2L);
        commandeType.setCompte(3L);

        Compte compte = new Compte();
        compte.setId(3L);

        when(compteService.getCompte(3L)).thenReturn(Optional.of(compte));

        Commande commande = new Commande();
        commande.setId(1L);

        try {
            controller.createCommandeType(commandeType);
            fail("Exception");
        } catch (ResponseStatusException ex) {
            assertEquals("il n'y a pas de commande avec ce code", ex.getReason());
        }
    }

    @Test
    public void testAjouterCommandeTypeErrorPresentation() throws SQLException {
        Commande commande = new Commande();
        commande.setId(1L);
        when(commandeService.getCommande(1L)).thenReturn(Optional.of(commande));

        Compte compte = new Compte();
        compte.setId(1L);

        try {
            controller.ajouterCommandeType(compte.getId(),commande.getId());
            fail("Exception");
        } catch (ResponseStatusException ex) {
            assertEquals("il n'y a pas de commande avec ce code", ex.getReason());
        }
    }
}


