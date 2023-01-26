package com.gromed.demo;

import com.gromed.demo.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Fixtures {

    /*public static Commande createCommande(Compte compte) {
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
        etablissement.setFinessej(23);
        etablissement.setLigneacheminement("hi");
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

    public static Medicament createMedicament(List<Informationsimportante> informationsimportantes, List<Conditionsmedicamenteuse> conditionsmedicamenteuses, List<Titulaire> titulaires, List<VoieAdministration> voieAdministrations,  StatutAdministratif statutAdministratif, TypeProcedure typeProcedure, EtatCommercialisation etatCommercialisation,FormePharmaceutique formePharmaceutique) {
        Medicament medicament = new Medicament();
        medicament.setId(64130871L);
        medicament.setInformationsimportantes(informationsimportantes);
        medicament.setConditionsmedicamenteuses(conditionsmedicamenteuses);
        medicament.setTitulaire(titulaires);
        medicament.setVoieadministrations(voieAdministrations);
        medicament.setNom("ACECLOFENAC BIOGARAN 100 mg, comprimé pelliculé");
        medicament.setFormepharmaceutique(formePharmaceutique);
        medicament.setStatutadministratif(statutAdministratif);
        medicament.setTypeprocedure(typeProcedure);
        medicament.setEtatcommercialisation(etatCommercialisation);
        medicament.setDateamm(LocalDate.ofEpochDay(2015-10-28));
        medicament.setStatusbdm("null");
        medicament.setNumeroautorisationeuropeenne("null");
        medicament.setSurveillancerenforcee("non");
        return medicament;
    }

    public static Avis createAvis() {
        Avis avis = new Avis();
        avis.setMotifevaluation("bou");
        avis.setDateavis(LocalDate.now());
        avis.setLien("jeje");
        avis.setTypeavis(true);
        avis.setCodehas(16);
        avis.setValeur("heh");
        avis.setLibelle("info");
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
        conditionsmedicamenteuse.setId("liste II");
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

    public static StatutAdministratif createStatusadministratif() {
        StatutAdministratif statutAdministratif = new StatutAdministratif();
        statutAdministratif.setId("Autorisation active");
        return statutAdministratif;
    }

    public static TypeProcedure createTypeprocedure() {
        TypeProcedure typeProcedure = new TypeProcedure();
        typeProcedure.setId("Procédure décentralisée");
        return typeProcedure;
    }

    public static EtatCommercialisation createEtatcommercialisation() {
        EtatCommercialisation etatCommercialisation = new EtatCommercialisation();
        etatCommercialisation.setId("Commercialisé");
        return etatCommercialisation;
    }

    public static FormePharmaceutique createFormepharmaceutique() {
        FormePharmaceutique formePharmaceutique = new FormePharmaceutique();
        formePharmaceutique.setId("comprimé pelliculé");
        return formePharmaceutique;
    }*/
}
