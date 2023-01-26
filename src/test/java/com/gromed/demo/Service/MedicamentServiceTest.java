package com.gromed.demo.Service;

import com.gromed.demo.model.Estdelivresous;
import com.gromed.demo.model.Medicament;
import com.gromed.demo.service.MedicamentService;
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

    @Test
    void getMedicament(){
        Optional<Medicament> medicament = medicamentService.getMedicament(Long.valueOf(62007051));
        List<Estdelivresous> estdelivresous = medicament.get().getEstdelivresous();
        estdelivresous.forEach(s->System.out.println(s.getId()));
        assertThat(estdelivresous).isNotNull();
    }

}
