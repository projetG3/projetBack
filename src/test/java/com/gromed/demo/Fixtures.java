package com.gromed.demo;

import com.gromed.demo.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Fixtures {

    public static Commande createCommande() {
        Commande commande = new Commande();
        commande.setDateheurecommande(LocalDateTime.now());
        commande.setStatus("en cours");
        commande.setMontanttotal("10");
        commande.setStatusfacture(true);
        commande.setDatefacture(LocalDate.now());
        commande.setNom("coucou");
        commande.setCompte(new Compte());
        return commande;
    }

    public static Presentation createPresentation() {
        Presentation presentation = new Presentation();
        presentation.setId(2);
        presentation.setLibelle("en cours");
        presentation.setStatus("ee");
        presentation.setEtatcommercialisation("ert");
        presentation.setDatecommercialisation(LocalDate.now());
        presentation.setCodecip13(23);
        presentation.setAgrement("tres");
        presentation.setPrix((long) 12.1);
        presentation.setIndications("mkejf");
        presentation.setQuantitedispo(1234);
        presentation.setCodecis(new Medicament());
        return presentation;
    }

    public static Estconstitueede createEstconstitueede(Commande commande, Presentation presentation) {
        Estconstitueede estconstitueede = new Estconstitueede();
        estconstitueede.setId(new EstconstitueedeId());
        estconstitueede.setCommande(commande);
        estconstitueede.setPresentation(presentation);
        estconstitueede.setQuantite(123);
        return estconstitueede;
    }
}
