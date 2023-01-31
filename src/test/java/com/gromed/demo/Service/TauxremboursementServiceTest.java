package com.gromed.demo.Service;

import com.gromed.demo.model.Tauxderemboursement;
import com.gromed.demo.service.TauxderemboursementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TauxremboursementServiceTest {

    @Autowired
    TauxderemboursementService tauxderemboursementService;

   @Test
   void getTauxremboursement(){
        Tauxderemboursement tauxderemboursement = tauxderemboursementService.getTauxDeRemboursement("100 %").orElseThrow();
        assertThat(tauxderemboursement.getId()).isEqualTo("100 %");
    }
}
