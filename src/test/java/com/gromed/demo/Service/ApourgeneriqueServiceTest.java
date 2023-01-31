package com.gromed.demo.Service;

import com.gromed.demo.model.Apourgenerique;
import com.gromed.demo.model.ApourgeneriqueId;
import com.gromed.demo.model.Generique;
import com.gromed.demo.service.ApourgeneriqueService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApourgeneriqueServiceTest {

    @Autowired
    ApourgeneriqueService apourgeneriqueService;

   @Test
    void getApourgenerique(){
        ApourgeneriqueId apourgeneriqueId = new ApourgeneriqueId();
        apourgeneriqueId.setCodecis(61945162L);
        apourgeneriqueId.setIdgenerique(79L);
        Optional<Apourgenerique> apourgenerique = apourgeneriqueService.getGenerique(apourgeneriqueId);
        Generique generique = apourgenerique.get().getGenerique();
        System.out.println(generique.getLibelle());
        assertThat(generique).isNotNull();
    }

}
