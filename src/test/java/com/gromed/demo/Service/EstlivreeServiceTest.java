package com.gromed.demo.Service;

import com.gromed.demo.model.Estlivree;
import com.gromed.demo.repository.EstlivreeRepository;
import com.gromed.demo.service.CommandeService;
import com.gromed.demo.service.CompteService;
import com.gromed.demo.service.EstlivreeService;
import com.gromed.demo.service.PresentationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EstlivreeServiceTest {

    @Autowired
    private EstlivreeService estlivreeService;

    @Autowired
    private CommandeService commandeService;

    @Autowired
    private PresentationService presentationService;

    /*@Test
    void createEstlivree(){
        Estlivree estlivree = new Estlivree();
        estlivree.setIdcommande(commandeService.getCommande(18L).orElseThrow());
        estlivree.setPresentation(presentationService.getPresentation(3016430L).orElseThrow());
        estlivree.setStatus("envoyer");
        estlivree.setDateenvoi(LocalDate.now());
        estlivree.setQuantite(1);
        estlivreeService.saveEstlivree(estlivree);
        assertThat(estlivree).isNotNull();
    }

     */
}
