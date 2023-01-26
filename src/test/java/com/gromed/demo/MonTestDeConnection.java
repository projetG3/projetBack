package com.gromed.demo;
import static org.assertj.core.api.Assertions.assertThat;

import com.gromed.demo.model.*;
import com.gromed.demo.repository.TauxderemboursementRepository;
import com.gromed.demo.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MonTestDeConnection {

    @Autowired
    TitulaireService titulaireService;
    @Autowired
    CompteService compteService;
    @Autowired
    MedicamentService medicamentService;
    @Autowired
    ConditionsmedicamenteuseService conditionsmedicamenteuseService;
    @Autowired
    TauxderemboursementService tauxderemboursementService;
    @Autowired
    PresentationService presentationService;
    @Autowired
    EtablissementService etablissementService;

    @Test
    public void addTitulaire() throws SQLException{
        Titulaire test = new Titulaire();
        test.setId("test");
        titulaireService.saveTitulaire(test);
        System.out.println("ADD TITULAIRE OK");
    }

    @Test
    public void addCompte() throws SQLException{
        Compte test = new Compte();
        test.setId(Long.valueOf(3456));
        test.setNom("test");
        test.setPrenom("test");
        Optional<Etablissement> etablissement = etablissementService.getEtablissement(Long.valueOf(80010184));
        System.out.println("test");
        System.out.println(etablissement.isPresent());
        System.out.println(etablissement.get().getId());
        test.setEtablissement(etablissement.get());
        test.setMotDePasse("1234");
        compteService.saveCompte(test);
        System.out.println("ADD Compte OK");
    }

    @Test
    public void getFirstCompte() throws SQLException{
        Optional <Compte> compte = compteService.getCompte(Long.valueOf(1));
        if(compte.isPresent()){
            System.out.println(compte.get().getPrenom());
        }
        System.out.println("GET FIRST COMPTE OK");
    }

    @Test
    public void getMedicament(){
        Optional<Medicament> medicament = medicamentService.getMedicament(Long.valueOf(62007051));
        List<Estdelivresous> estdelivresous = medicament.get().getEstdelivresous();
        estdelivresous.forEach(s->System.out.println(s.getId()));
        assertThat(estdelivresous).isNotNull();
    }

    @Test
    public void getConditionsmedicamenteuse(){
        Optional<Conditionsmedicamenteuse> conditionsmedicamenteuse = conditionsmedicamenteuseService.getConditionsmedicamenteuse("pour toute antériorité de traitement supérieur à 1 an :");
        assertThat(conditionsmedicamenteuse.get().getId()).isEqualTo("pour toute antériorité de traitement supérieur à 1 an :");
    }

    @Test
    public void getTauxremboursement(){
        Optional<Tauxderemboursement> tauxderemboursement = tauxderemboursementService.getTauxDeRemboursement("100 %");
        assertThat(tauxderemboursement.get().getId()).isEqualTo("100 %");
    }

    @Test
    public void getPresentation(){
        Optional<Presentation> presentation = presentationService.getPresentation(Long.valueOf(3939752));
        List<Tauxderemboursement> tauxderemboursements = presentation.get().getTauxderemboursements();
        tauxderemboursements.forEach(s->System.out.println(s.getId()));
        assertThat(tauxderemboursements).isNotNull();
    }
}
