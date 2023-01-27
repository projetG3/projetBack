package com.gromed.demo.Service;

import com.gromed.demo.model.*;
import com.gromed.demo.service.EstconstitueedeService;
import com.gromed.demo.service.PresentationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PresentationServiceTest {

    @Autowired
    PresentationService presentationService;
    @Autowired
    private EstconstitueedeService estconstitueedeService;
    @Test
    void getCommande() {
        List<Commande> commandes = new ArrayList<>();
        List<Estconstitueede> estconstitueedes = estconstitueedeService.getAllEstconstitueedes();
        //System.out.println("bb" + estconstitueedes.get(0).getCommande());
        //estconstitueedes.forEach(s -> commandes.add(s.getCommande()));
    }

    @Test
    void getPresentation(){
        Optional<Presentation> presentation = presentationService.getPresentation(Long.valueOf(2663360));
        List<Estrembourseea> estrembourseeas = presentation.get().getEstremboursea();
        estrembourseeas.forEach(s->System.out.println(s.getId()));
        assertThat(estrembourseeas).isNotNull();
    }

    @Test
    void getPresentationMedicament(){
        Optional<Presentation> presentation = presentationService.getPresentation(Long.valueOf(2663360));
        Medicament medicament = presentation.get().getCodecis();
        System.out.println(medicament.getId());
        assertThat(medicament).isNotNull();
    }
}
