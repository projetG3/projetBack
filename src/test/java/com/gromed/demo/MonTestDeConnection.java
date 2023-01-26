package com.gromed.demo;
import static org.assertj.core.api.Assertions.assertThat;

import com.gromed.demo.model.*;
import com.gromed.demo.repository.ConditionsmedicamenteuseRepository;
import com.gromed.demo.repository.MedicamentRepository;
import com.gromed.demo.service.CompteService;
import com.gromed.demo.service.ConditionsmedicamenteuseService;
import com.gromed.demo.service.MedicamentService;
import com.gromed.demo.service.TitulaireService;
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
    ConditionsmedicamenteuseRepository conditionsmedicamenteuseRepository;
    @Autowired
    MedicamentRepository medicamentRepository;
    @Autowired
    ConditionsmedicamenteuseService conditionsmedicamenteuseService;

    @Test
    public void addTitulaire() throws SQLException{

        Titulaire test = new Titulaire();
        test.setId("mon testééé");
        titulaireService.saveTitulaire(test);
        System.out.println("ADD TITULAIRE OK");
    }

    @Test
    public void getFirstCompte() throws SQLException{
        Optional <Compte> compte = compteService.getCompte(1);
        if(compte.isPresent()){
            System.out.println(compte.get().getPrenom());
        }
        System.out.println("GET FIRST COMPTE OK");
    }

    @Test
    public void getConditionsMedicamenteuse(){
        //List<Medicament> medicaments = medicamentService.getAllMedicament();
        //Optional<Medicament> medicament = medicaments.stream().findFirst();
        Optional<Medicament> medicament = medicamentService.getMedicament(Long.valueOf(62007051));
        //List<Estdelivresous> estdelivresous = medicament.get().getEstdelivresous();
        //estdelivresous.forEach(s->System.out.println(s));
        //System.out.println(estdelivresous.get(0).getId());
        //assertThat(estdelivresous).isNotNull();
        //estdelivresous.forEach(s->System.out.println(s));
    }

    @Test
    public void getConditionsmedicamenteuse(){
        Optional<Conditionsmedicamenteuse> conditionsmedicamenteuse = conditionsmedicamenteuseService.getConditionsmedicamenteuse("pour toute antériorité de traitement supérieur à 1 an :");
        System.out.println(conditionsmedicamenteuse.get().getId());
    }
}
