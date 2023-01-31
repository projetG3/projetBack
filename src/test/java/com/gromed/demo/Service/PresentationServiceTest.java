package com.gromed.demo.Service;

import com.gromed.demo.model.*;
import com.gromed.demo.service.EstconstitueedeService;
import com.gromed.demo.service.PresentationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

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
        assertThat(estconstitueedes).isNotNull();
    }

    @Test
    void getPresentation(){
        Presentation presentation = presentationService.getPresentation(2663360L).orElseThrow();
        List<Estrembourseea> estrembourseeas = presentation.getEstremboursea();
        estrembourseeas.forEach(s->System.out.println(s.getId()));
        assertThat(estrembourseeas).isNotNull();
    }

    @Test
    void getPresentationMedicament(){
        Presentation presentation = presentationService.getPresentation(2663360L).orElseThrow();
        Medicament medicament = presentation.getCodecis();
        System.out.println(medicament.getId());
        assertThat(medicament).isNotNull();
    }
}
