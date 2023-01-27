package com.gromed.demo.Service;

import com.gromed.demo.model.Avis;
import com.gromed.demo.model.Medicament;
import com.gromed.demo.service.AvisService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AvisServiceTest {

    @Autowired
    AvisService avisService;

   /* @Test
    void getAvis(){
        Optional<Avis> avis = avisService.getAvis(Long.valueOf(55));
        Medicament medicament = avis.get().getCodecis();
        System.out.println(medicament.getId());
        assertThat(medicament).isNotNull();
    }

    */
}