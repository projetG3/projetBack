package com.gromed.demo;

import com.gromed.demo.model.*;
import com.gromed.demo.repository.*;
import com.gromed.demo.service.EstconstitueedeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EstconstitueedeTest {

    @Autowired
    private EstconstitueedeRepository estconstitueedeRepository;
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private PresentationRepository presentationRepository;
    @Autowired
    private ServicepublichospitalierRepository servicepublichospitalierRepository;
    @Autowired
    private ModedefixationdestarifRepository modedefixationdestarifRepository;
    @Autowired
    private CodeapeRepository codeapeRepository;
    @Autowired
    private CategorieetablissementRepository categorieetablissementRepository;
    @Autowired
    private EtablissementRepository etablissementRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private AvisRepository avisRepository;
    @Autowired
    private CompositionRepository compositionRepository;
    @Autowired
    private InformationsimportanteRepository informationsimportanteRepository;
    @Autowired
    private ConditionsmedicamenteuseRepository conditionsmedicamenteuseRepository;
    @Autowired
    private TitulaireRepository titulaireRepository;
    @Autowired
    private VoieAdministrationRepository voieAdministrationRepository;
    @Autowired
    private MedicamentRepository medicamentRepository;

    @Test
    public void testRepo1() {
        final var servicepublichospitalier = Fixtures.createServicepublichospitalier();
        final var modedefixationdestarif = Fixtures.createModefixationdestarif();
        final var codeape = Fixtures.createCodeape();
        final var categorie = Fixtures.createCategorie();
        final var etablissement = Fixtures.createEtablissement(servicepublichospitalier, modedefixationdestarif, codeape, categorie);
        final var compte = Fixtures.createCompte(etablissement);
        final var commande = Fixtures.createCommande(compte);
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
        final var medicament = Fixtures.createMedicament(avisList, compositions, informationsimportantes,  conditionsmedicamenteuses, titulaires, voieAdministrations);
        final var presentation = Fixtures.createPresentation(medicament);
        final var estconstitueedeId = Fixtures.createEstconstitueedeid();
        final var estconstitueede = Fixtures.createEstconstitueede(commande, presentation, estconstitueedeId);

        servicepublichospitalierRepository.save(servicepublichospitalier);
        modedefixationdestarifRepository.save(modedefixationdestarif);
        codeapeRepository.save(codeape);
        categorieetablissementRepository.save(categorie);
        etablissementRepository.save(etablissement);
        compteRepository.save(compte);
        avisRepository.saveAll(avisList);
        compositionRepository.save(composition);
        informationsimportanteRepository.saveAll(informationsimportantes);
        conditionsmedicamenteuseRepository.saveAll(conditionsmedicamenteuses);
        titulaireRepository.save(titulaire);
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
}
