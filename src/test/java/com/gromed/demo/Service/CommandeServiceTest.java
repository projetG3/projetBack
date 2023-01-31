package com.gromed.demo.Service;

import com.gromed.demo.model.Commande;
import com.gromed.demo.model.Compte;
import com.gromed.demo.model.Estconstitueede;
import com.gromed.demo.service.CommandeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CommandeServiceTest {

    @Autowired
    CommandeService commandeService;

    @Test
    void getCompte(){
        Optional<Commande> commande = commandeService.getCommande(Long.valueOf(3));
        Compte compte = commande.get().getCompte();
        System.out.println(compte.getId());
        assertThat(compte.getId()).isEqualTo(5);
    }

    @Test
    void getEstconstitueede(){
        Optional<Commande> commande = commandeService.getCommande(18L);
        List<Estconstitueede> estconstitueedes = commande.get().getEstconstitueedes();
        for (Estconstitueede e: estconstitueedes) {
            System.out.println(e.getId());
        }
    }
}
