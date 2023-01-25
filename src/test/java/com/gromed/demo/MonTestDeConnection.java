package com.gromed.demo;

import com.gromed.demo.model.Compte;
import com.gromed.demo.model.Titulaire;
import com.gromed.demo.service.CompteService;
import com.gromed.demo.service.TitulaireService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.Optional;

@SpringBootTest
public class MonTestDeConnection {

    @Autowired
    TitulaireService titulaireService;

    @Autowired
    CompteService compteService;

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
}
