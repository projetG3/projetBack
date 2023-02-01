package com.gromed.demo.Service;

import com.gromed.demo.model.Commande;
import com.gromed.demo.model.Compte;
import com.gromed.demo.model.Estconstitueede;
import com.gromed.demo.service.CommandeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CommandeServiceTest {

    @Autowired
    CommandeService commandeService;

   /* @Test
    void getCompte(){
        Commande commande = commandeService.getCommande(19L).orElseThrow();
        Compte compte = commande.getCompte();
        System.out.println(compte.getId());
        assertThat(compte.getId()).isEqualTo(10);
    }

    @Test
    void getEstconstitueede(){
        Commande commande = commandeService.getCommande(18L).orElseThrow();
        List<Estconstitueede> estconstitueedes = commande.getEstconstitueedes();
        for (Estconstitueede e: estconstitueedes) {
            System.out.println(e.getId());
        }
    }

    */
}
