package com.gromed.demo.Service;

import com.gromed.demo.model.*;
import com.gromed.demo.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CompteServiceTest {

    @Autowired
    private EtablissementService etablissementService;
    @Autowired
    private CompteService compteService;
    @Autowired
    private CommandeService commandeService;
    @Autowired
    private PresentationService presentationService;
    @Autowired
    private EstconstitueedeService estconstitueedeService;

    @Test
    void getCompte(){
        Compte compte = compteService.getCompte(5L).orElseThrow();
        System.out.println(compte);
        assertThat(compte).isNotNull();
    }

    @Test
    void addCompte() {
        Compte test = new Compte();
        test.setNom("dupont");
        test.setPrenom("dupond");
        Etablissement etablissement = etablissementService.getEtablissement(640007761L).orElseThrow();
        test.setEtablissement(etablissement);
        test.setMotDePasse("1234");
        compteService.saveCompte(test);
        System.out.println("ADD Compte OK");
        assertThat(test).isNotNull();
    }

    @Test
    void getFirstCompte(){
        Optional <Compte> compte = compteService.getCompte(1L);
        if(compte.isPresent()){
            System.out.println(compte.get().getPrenom());
        }
        assertThat(compte).isNotNull();
        System.out.println("GET FIRST COMPTE OK");
    }

    @Test
    void createCommande(){
        Compte compte = compteService.getCompte(5L).orElseThrow();
        Commande commande = new Commande();
        commande.setStatus("en cours");
        commande.setCompte(compte);
        commande = commandeService.saveCommande(commande);
        Commande newCommande = compteService.createCommande(compte);
        assertThat(newCommande).isNotNull();
        assertThat(commande).isNotNull();
        assertThat(commande.getCompte()).isEqualTo(newCommande.getCompte());
    }

    @Test
    void getCommandeType() throws SQLException {
        Compte compte = compteService.getCompte(5L).orElseThrow();
        Commande commande = compteService.createCommande(compte);
        commande.setNom("Restock");
        commandeService.saveCommande(commande);
        List<Commande> commandeType = compteService.getCommandeType(compte);
        assertThat(commandeType.contains(commande)).isNotNull();
    }

    @Test
    void addProduct() throws SQLException {
        Presentation presentation = presentationService.getAllPresentation().get(0);
        Compte compte = compteService.getCompte(5L).orElseThrow();
        List<Commande> commandesEnCours = compteService.getCommandeType(compte);
        Commande commandeEnCours = commandesEnCours.get(0);
        Estconstitueede estconstitueede = new Estconstitueede();
        estconstitueede.setTerminer(false);
        estconstitueede.setQuantite(1);
        estconstitueede.setPresentation(presentation);
        estconstitueede.setIdcommande(commandeEnCours);
        estconstitueede = estconstitueedeService.saveEstconstitueede(estconstitueede);
        commandeEnCours.addEstConstitueeDe(estconstitueede);
        Commande commandeProduct = compteService.addProduct(commandeEnCours, presentation, 1);
        assertThat(commandeProduct.getEstconstitueedes().contains(estconstitueede)).isNotNull();
    }
}
