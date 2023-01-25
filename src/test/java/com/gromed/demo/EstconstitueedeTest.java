package com.gromed.demo;

import com.gromed.demo.model.*;
import com.gromed.demo.repository.*;
import com.gromed.demo.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EstconstitueedeTest {

    @Autowired
    EstconstitueedeRepository estconstitueedeRepository;
    @Autowired
    CommandeRepository commandeRepository;
    @Autowired
    PresentationRepository presentationRepository;
    @Autowired
    ServicepublichospitalierRepository servicepublichospitalierRepository;
    @Autowired
    ModedefixationdestarifRepository modedefixationdestarifRepository;
    @Autowired
    CodeapeRepository codeapeRepository;
    @Autowired
    CategorieetablissementRepository categorieetablissementRepository;
    @Autowired
    EtablissementRepository etablissementRepository;
    @Autowired
    CompteRepository compteRepository;
    @Autowired
    AvisRepository avisRepository;
    @Autowired
    CompositionRepository compositionRepository;
    @Autowired
    InformationsimportanteRepository informationsimportanteRepository;
    @Autowired
    ConditionsmedicamenteuseRepository conditionsmedicamenteuseRepository;
    @Autowired
    TitulaireRepository titulaireRepository;
    @Autowired
    VoieAdministrationRepository voieAdministrationRepository;
    @Autowired
    MedicamentRepository medicamentRepository;
    @Autowired
    AvisService avisService;
    @Autowired
    MedicamentService medicamentService;
    @Autowired
    TitulaireService titulaireService;
    @Autowired
    StatutAdministratifRepository statutAdministratifRepository;
    @Autowired
    TypeProcedureRepository typeProcedureRepository;
    @Autowired
    EtatCommercialisationRepository etatCommercialisationRepository;
    @Autowired
    FormePharmaceutiqueRepository formePharmaceutiqueRepository;
    @Autowired
    EtatCommercialisationService etatCommercialisationService;


    public EstconstitueedeTest() {
    }

    @Test
    public void addTitulaire() throws SQLException {

        Titulaire test = new Titulaire();
        test.setId("mon test");
        titulaireService.saveTitulaire(test);
        System.out.println("ADD TITULAIRE OK");
    }

    @Test
    public void testEtatCommercialisation(){
        EtatCommercialisation etatCommercialisation = Fixtures.createEtatcommercialisation();
        etatCommercialisationRepository.save(etatCommercialisation);
        EtatCommercialisation e = etatCommercialisationService.saveEtatcommercial(etatCommercialisation);
        assertThat(e).isNotNull();
    }
    @Test
    public void testAvis(){
        InformationsimportanteId informationsimportanteId = Fixtures.createInformationsimportantesid();
        Informationsimportante informationsimportante = Fixtures.createInformationsimportantes(informationsimportanteId);
        Conditionsmedicamenteuse conditionsmedicamenteuse = Fixtures.createConditionsmedicamenteuses();
        Titulaire titulaire = Fixtures.createTitulaires();
        VoieAdministration voieAdministration = Fixtures.createVoieadministrations();
        List<Informationsimportante> informationsimportantes = new ArrayList<>();
        informationsimportantes.add(informationsimportante);
        List<Conditionsmedicamenteuse> conditionsmedicamenteuses = new ArrayList<>();
        conditionsmedicamenteuses.add(conditionsmedicamenteuse);
        List<Titulaire> titulaires = new ArrayList<>();
        titulaires.add(titulaire);
        List<VoieAdministration> voieAdministrations = new ArrayList<>();
        voieAdministrations.add(voieAdministration);
        for (Informationsimportante i: informationsimportantes) {
            informationsimportanteRepository.save(i);
        }
        for (Conditionsmedicamenteuse c: conditionsmedicamenteuses) {
            conditionsmedicamenteuseRepository.save(c);
        }
        for (Titulaire t: titulaires) {
            titulaireRepository.save(t);
        }
        voieAdministrationRepository.save(voieAdministration);
        StatutAdministratif statutAdministratif = Fixtures.createStatusadministratif();
        TypeProcedure typeProcedure = Fixtures.createTypeprocedure();
        EtatCommercialisation etatCommercialisation = Fixtures.createEtatcommercialisation();
        FormePharmaceutique formePharmaceutique = Fixtures.createFormepharmaceutique();
        statutAdministratifRepository.save(statutAdministratif);
        typeProcedureRepository.save(typeProcedure);
        etatCommercialisationRepository.save(etatCommercialisation);
        formePharmaceutiqueRepository.save(formePharmaceutique);
        Medicament medicament = Fixtures.createMedicament(informationsimportantes, conditionsmedicamenteuses, titulaires, voieAdministrations, statutAdministratif, typeProcedure, etatCommercialisation, formePharmaceutique);
        medicamentService.saveMedicament(medicament);
        Avis avis = new Avis();
        avis.setId(1456890);
        avis.setMotifevaluation("bou");
        avis.setDateavis(LocalDate.now());
        avis.setLien("jeje");
        avis.setTypeavis(true);
        avis.setCodehas(16);
        avis.setValeur("heh");
        avis.setLibelle("info");
        avis.setCodecis(medicament);
        Avis a = avisService.saveAvis(avis);
        assertThat(a).isNotNull();
    }
/*
    @Test
    public void testRepo1() {
        final var servicepublichospitalier = Fixtures.createServicepublichospitalier();
        final var modedefixationdestarif = Fixtures.createModefixationdestarif();
        final var codeape = Fixtures.createCodeape();
        final var categorie = Fixtures.createCategorie();
        final var etablissement = Fixtures.createEtablissement(servicepublichospitalier, modedefixationdestarif, codeape, categorie);
        final var compte = Fixtures.createCompte(etablissement);
        final var commande = Fixtures.createCommande(compte);
        //final var avisId = Fixtures.createAvisid();
        final var avis = Fixtures.createAvis();
        final var composition = Fixtures.createComposition();
        final var informationsimportanteId = Fixtures.createInformationsimportantesid();
        final var informationsimportante = Fixtures.createInformationsimportantes(informationsimportanteId);
        final var conditionsmedicamenteuse = Fixtures.createConditionsmedicamenteuses();
        final var titulaire = Fixtures.createTitulaires();
        final var voieAdministration = Fixtures.createVoieadministrations();
        List<Avis> avisList = new ArrayList<>();
        avisList.add(avis);
        List<Composition> compositions = new ArrayList<>();
        compositions.add(composition);
        List<Informationsimportante> informationsimportantes = new ArrayList<>();
        informationsimportantes.add(informationsimportante);
        List<Conditionsmedicamenteuse> conditionsmedicamenteuses = new ArrayList<>();
        conditionsmedicamenteuses.add(conditionsmedicamenteuse);
        List<Titulaire> titulaires = new ArrayList<>();
        titulaires.add(titulaire);
        List<VoieAdministration> voieAdministrations = new ArrayList<>();
        voieAdministrations.add(voieAdministration);
        final var medicament = Fixtures.createMedicament(compositions, informationsimportantes,  conditionsmedicamenteuses, titulaires, voieAdministrations);
        final var presentation = Fixtures.createPresentation(medicament);
        final var estconstitueedeId = Fixtures.createEstconstitueedeid();
        final var estconstitueede = Fixtures.createEstconstitueede(commande, presentation, estconstitueedeId);

        servicepublichospitalierRepository.save(servicepublichospitalier);
        modedefixationdestarifRepository.save(modedefixationdestarif);
        codeapeRepository.save(codeape);
        categorieetablissementRepository.save(categorie);
        etablissementRepository.save(etablissement);
        compteRepository.save(compte);
        for (Avis a: avisList) {
            avisRepository.save(a);
        }
        for (Composition c: compositions) {
            compositionRepository.save(composition);
        }
        for (Informationsimportante i: informationsimportantes) {
            informationsimportanteRepository.save(i);
        }
        for (Conditionsmedicamenteuse c: conditionsmedicamenteuses) {
            conditionsmedicamenteuseRepository.save(c);
        }
        for (Titulaire t: titulaires) {
            titulaireRepository.save(t);
        }
        voieAdministrationRepository.save(voieAdministration);
        medicamentRepository.save(medicament);
        commandeRepository.save(commande);
        presentationRepository.save(presentation);
        estconstitueedeRepository.save(estconstitueede);
        List<Estconstitueede> pEstconstitueede = estconstitueedeRepository.findAll();
        System.out.println(pEstconstitueede.size());
        assertThat(pEstconstitueede).isNotNull();
        assertThat(pEstconstitueede).isNotNull().isNotSameAs(estconstitueede);
        assertThat(pEstconstitueede.get(0)).isEqualTo(pEstconstitueede.get(0));
    }

 */
}
