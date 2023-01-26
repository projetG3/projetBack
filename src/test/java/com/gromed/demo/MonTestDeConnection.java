package com.gromed.demo;

import com.gromed.demo.model.Compte;
import com.gromed.demo.model.Conditionsmedicamenteuse;
import com.gromed.demo.model.Medicament;
import com.gromed.demo.model.Titulaire;
import com.gromed.demo.repository.ConditionsmedicamenteuseRepository;
import com.gromed.demo.repository.MedicamentRepository;
import com.gromed.demo.service.CompteService;
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
    private ConditionsmedicamenteuseRepository conditionsmedicamenteuseRepository;
    @Autowired
    private MedicamentRepository medicamentRepository;

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
/*
    @Test
    public void getConditionsMedicamenteuse(){
        //List<Medicament> medicaments = medicamentService.getAllMedicament();
        //Optional<Medicament> medicament = medicaments.stream().findFirst();
        Optional<Medicament> medicament = medicamentService.getMedicament(68696906L);
        List<Conditionsmedicamenteuse> conditionsmedicamenteuses = medicament.get().getConditionsmedicamenteuses();
        System.out.println(conditionsmedicamenteuses.size());
    }

 */
}
