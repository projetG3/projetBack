package com.gromed.demo;

import com.gromed.demo.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Fixtures {

    public static Commande createCommande(Compte compte) {
        Commande commande = new Commande();
        commande.setId(12);
        commande.setDateheurecommande(LocalDateTime.now());
        commande.setStatus("en cours");
        commande.setMontanttotal("10");
        commande.setStatusfacture(true);
        commande.setDatefacture(LocalDate.now());
        commande.setNom("coucou");
        commande.setCompte(compte);
        return commande;
    }

    public static Presentation createPresentation(Medicament medicament) {
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
        presentation.setCodecis(medicament);
        return presentation;
    }

    public static Estconstitueede createEstconstitueede(Commande commande, Presentation presentation, EstconstitueedeId estconstitueedeId) {
        Estconstitueede estconstitueede = new Estconstitueede();
        estconstitueede.setId(estconstitueedeId);
        estconstitueede.setCommande(commande);
        estconstitueede.setPresentation(presentation);
        estconstitueede.setQuantite(123);
        return estconstitueede;
    }

    public static Compte createCompte(Etablissement etablissement) {
        Compte compte = new Compte();
        compte.setId(13);
        compte.setNom("bou");
        compte.setPrenom("hi");
        compte.setEtablissement(etablissement);
        compte.setMotDePasse("bonjour");
        return compte;
    }

    public static Etablissement createEtablissement(Servicepublichospitalier servicepublichospitalier, Modedefixationdestarif modedefixationdestarif, Codeape codeape, Categorieetablissement categorieetablissement) {
        Etablissement etablissement = new Etablissement();
        etablissement.setId(14);
        etablissement.setFinessej("bou");
        etablissement.setFinessej("hi");
        etablissement.setSiret(3456);
        etablissement.setDateouverture(LocalDate.now());
        etablissement.setDateautorisation(LocalDate.now());
        etablissement.setDatemajstructure(LocalDate.now());
        etablissement.setNumerouai("bonjour");
        etablissement.setCoordsource("bonjour");
        etablissement.setTelephone("bonjour");
        etablissement.setTelecopie("bonjour");
        etablissement.setRaisonsociale("bonjour");
        etablissement.setComplementraisonsociale("bonjour");
        etablissement.setComplementdistribution("bonjour");
        etablissement.setCoordx((long) 13.5);
        etablissement.setCoordy((long) 16.5);
        etablissement.setNumerovoie(1);
        etablissement.setNomvoie("bonjour");
        etablissement.setComplementvoie((char) 2);
        etablissement.setLieudit("bonjour");
        etablissement.setCodecommune(23456);
        etablissement.setDatemajcoord(LocalDate.now());
        etablissement.setCodedepartement("bonjour");
        etablissement.setNomdepartement("bonjour");
        etablissement.setCodesph(servicepublichospitalier);
        etablissement.setCodemft(modedefixationdestarif);
        etablissement.setCodeape(codeape);
        etablissement.setCategorie(categorieetablissement);
        return etablissement;
    }

    public static Servicepublichospitalier createServicepublichospitalier() {
        Servicepublichospitalier servicepublichospitalier = new Servicepublichospitalier();
        servicepublichospitalier.setId(13);
        servicepublichospitalier.setLibelle("bou");
        return servicepublichospitalier;
    }

    public static Modedefixationdestarif createModefixationdestarif() {
        Modedefixationdestarif modedefixationdestarif = new Modedefixationdestarif();
        modedefixationdestarif.setId(13);
        modedefixationdestarif.setLibelle("bou");
        return modedefixationdestarif;
    }

    public static Codeape createCodeape() {
        Codeape codeape = new Codeape();
        codeape.setId("13");
        return codeape;
    }

    public static Categorieetablissement createCategorie() {
        Categorieetablissement categorieetablissement = new Categorieetablissement();
        categorieetablissement.setId(13);
        categorieetablissement.setLibellecategorie("bou");
        categorieetablissement.setCategorieagregat("hi");
        categorieetablissement.setLibelleagregat("jeje");
        return categorieetablissement;
    }

    public static Medicament createMedicament(List<Avis> avis, List<Composition> compositions, List<Informationsimportante> informationsimportantes, List<Conditionsmedicamenteuse> conditionsmedicamenteuses, List<Titulaire> titulaires, List<VoieAdministration> voieAdministrations) {
        Medicament medicament = new Medicament();
        medicament.setId(14);
        medicament.setAvis(avis);
        medicament.setCompositions(compositions);
        medicament.setInformationsimportantes(informationsimportantes);
        medicament.setConditionsmedicamenteuses(conditionsmedicamenteuses);
        medicament.setTitulaire(titulaires);
        medicament.setVoieadministrations(voieAdministrations);
        medicament.setNom("bonjour");
        medicament.setFormepharmaceutique("bonjour");
        medicament.setStatutadministratif("bonjour");
        medicament.setTypeprocedure("bonjour");
        medicament.setEtatcommercialisation("bonjour");
        medicament.setDateamm(LocalDate.now());
        medicament.setStatusbdm("bonjour");
        medicament.setNumeroautorisationeuropeenne("13.3");
        medicament.setSurveillancerenforcee(true);
        return medicament;
    }

    public static Avis createAvis() {
        Avis avis = new Avis();
        avis.setId(new AvisId());
        avis.setMotifevaluation("bou");
        avis.setDateavis(LocalDate.now());
        avis.setLien("jeje");
        avis.setTypeavis(true);
        return avis;
    }

    public static Composition createComposition() {
        Composition composition = new Composition();
        composition.setId(13);
        composition.setCodesubstance(12);
        composition.setDesignationpharmaceutique("hi");
        composition.setDenominationsubstance("jeje");
        composition.setDosage("jeje");
        composition.setReferencedosage("jeje");
        composition.setNature("jeje");
        composition.setNumerolier(2);
        return composition;
    }

    public static Informationsimportante createInformationsimportantes(InformationsimportanteId informationsimportanteId) {
        Informationsimportante informationsimportante = new Informationsimportante();
        informationsimportante.setId(informationsimportanteId);
        return informationsimportante;
    }

    public static Conditionsmedicamenteuse createConditionsmedicamenteuses() {
        Conditionsmedicamenteuse conditionsmedicamenteuse = new Conditionsmedicamenteuse();
        conditionsmedicamenteuse.setId("13");
        return conditionsmedicamenteuse;
    }

    public static Titulaire createTitulaires() {
        Titulaire titulaire = new Titulaire();
        titulaire.setId("13");
        return titulaire;
    }

    public static VoieAdministration createVoieadministrations() {
        VoieAdministration voieAdministration = new VoieAdministration();
        voieAdministration.setId("13");
        return voieAdministration;
    }

    public static EstconstitueedeId createEstconstitueedeid() {
        EstconstitueedeId estconstitueedeId = new EstconstitueedeId();
        estconstitueedeId.setCodecip7(1);
        estconstitueedeId.setIdcommande(2);
        return estconstitueedeId;
    }

    public static InformationsimportanteId createInformationsimportantesid() {
        InformationsimportanteId informationsimportanteId = new InformationsimportanteId();
        informationsimportanteId.setDatedebutinfo(LocalDate.now());
        informationsimportanteId.setDatefininfo(LocalDate.now());
        informationsimportanteId.setInformation("info");
        return informationsimportanteId;
    }
}
