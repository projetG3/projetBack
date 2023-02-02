package com.gromed.demo.Controller;

import com.gromed.demo.controller.CommandeController;
import com.gromed.demo.controller.CompteController;
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
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CompteControllerTest {
    @Mock
    private CompteService compteService;
    @InjectMocks
    private CompteController controller;

    @Test
    public void testCheckUser() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPassword("1234");
        utilisateur.setId(2L);

        Compte compte = new Compte();
        compte.setId(2L);
        compte.setMotDePasse("1234");

        when(compteService.getCompte(2L)).thenReturn(Optional.of(compte));

        Compte response = controller.checkUser(utilisateur);
        assertEquals(response, compte);
    }

    @Test
    public void testCheckUserErrorPresentation() throws SQLException {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPassword("1234");
        utilisateur.setId(2L);

        CompteService compteService = mock(CompteService.class);

        try {
            controller.checkUser(utilisateur);
            fail("Exception");
        } catch (ResponseStatusException ex) {
            assertEquals("Cette ID n'existe pas", ex.getReason());
        }
    }

    /*@Test
    public void testCheckUserErrorCompte() throws SQLException {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setPassword("1234");
        utilisateur.setId(2L);

        Compte compte = new Compte();
        compte.setId(3L);
        compte.setMotDePasse("1234");

        when(compteService.getCompte(2L)).thenReturn(Optional.of(compte));

        try {
            controller.checkUser(utilisateur);
            fail("Exception");
        } catch (ResponseStatusException ex) {
            assertEquals("Il manque le numéro du produit souhaité ou la quantité souhaitée ou votre identifiant", ex.getReason());
        }
    }

     */
}


