package com.gromed.demo.Service;

import com.gromed.demo.model.Composition;
import com.gromed.demo.model.Medicament;
import com.gromed.demo.service.CompositionsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CompositionServiceTest {

    @Autowired
    CompositionsService compositionsService;

    /*@Test
    void getComposition(){
        Optional<Composition> composition = compositionsService.getComposition(Long.valueOf(318));
        Medicament medicament = composition.get().getCodecis();
        System.out.println(medicament.getId());
        assertThat(medicament).isNotNull();
    }

     */
}