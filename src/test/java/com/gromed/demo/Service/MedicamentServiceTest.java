package com.gromed.demo.Service;

import com.gromed.demo.model.*;
import com.gromed.demo.service.MedicamentService;
import com.gromed.demo.service.PresentationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MedicamentServiceTest {

    @Autowired
    MedicamentService medicamentService;
    @Autowired
    PresentationService presentationService;

   /*@Test
    void getMedicament(){
        Medicament medicament = medicamentService.getMedicament(62007051L).orElseThrow();
        List<Estdelivresous> estdelivresous = medicament.getEstdelivresous();
        estdelivresous.forEach(s->System.out.println(s.getId()));
        assertThat(estdelivresous).isNotNull();
    }

    @Test
    void getMedicamentAdministrepar(){
        Medicament medicament = medicamentService.getMedicament(62007051L).orElseThrow();
        List<Administrepar> administrepars = medicament.getAdministrepars();
        administrepars.forEach(s->System.out.println(s.getVoieadministration().getId()));
        assertThat(administrepars).isNotNull();
    }

    @Test
    void getMedicamentInforme(){
        Presentation presentation = presentationService.getPresentation(3939752L).orElseThrow();
        Medicament medicament = presentation.getCodecis();
        System.out.println(medicament.getId());
        List<Informe> informes = medicament.getInformes();
        informes.forEach(s->System.out.println(s.getInformationsimportantes().getId().getInformation()));
        assertThat(informes).isNotNull();
    }

    */
}
