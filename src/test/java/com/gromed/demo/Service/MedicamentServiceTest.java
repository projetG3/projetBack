package com.gromed.demo.Service;

import com.gromed.demo.model.*;
import com.gromed.demo.service.MedicamentService;
import com.gromed.demo.service.PresentationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MedicamentServiceTest {

    @Autowired
    MedicamentService medicamentService;
    @Autowired
    PresentationService presentationService;

   /* @Test
    void getMedicament(){
        Optional<Medicament> medicament = medicamentService.getMedicament(Long.valueOf(62007051));
        List<Estdelivresous> estdelivresous = medicament.get().getEstdelivresous();
        estdelivresous.forEach(s->System.out.println(s.getId()));
        assertThat(estdelivresous).isNotNull();
    }

    @Test
    void getMedicamentAdministrepar(){
        Optional<Medicament> medicament = medicamentService.getMedicament(Long.valueOf(62007051));
        List<Administrepar> administrepars = medicament.get().getAdministrepars();
        administrepars.forEach(s->System.out.println(s.getVoieadministration().getId()));
        assertThat(administrepars).isNotNull();
    }

    @Test
    void getMedicamentInforme(){
        Optional<Presentation> presentation = presentationService.getPresentation(Long.valueOf(3939752));
        Medicament medicament = presentation.get().getCodecis();
        System.out.println(medicament.getId());
        List<Informe> informes = medicament.getInformes();
        informes.forEach(s->System.out.println(s.getInformationsimportantes().getId().getInformation()));
        assertThat(informes).isNotNull();
    }

    */

}
