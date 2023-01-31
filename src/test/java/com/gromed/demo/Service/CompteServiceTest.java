package com.gromed.demo.Service;

import com.gromed.demo.model.Compte;
import com.gromed.demo.model.Etablissement;
import com.gromed.demo.service.CompteService;
import com.gromed.demo.service.EtablissementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CompteServiceTest {

    @Autowired
    private EtablissementService etablissementService;
    @Autowired
    private CompteService compteService;

    @Test
    void getCompte(){
        Optional<Compte> compte = compteService.getCompte(Long.valueOf(5));
        System.out.println(compte.get());
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
}
