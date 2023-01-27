package com.gromed.demo.Service;

import com.gromed.demo.model.Tauxderemboursement;
import com.gromed.demo.service.TauxderemboursementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TauxremboursementServiceTest {

    @Autowired
    TauxderemboursementService tauxderemboursementService;

   /* @Test
   void getTauxremboursement(){
        Optional<Tauxderemboursement> tauxderemboursement = tauxderemboursementService.getTauxDeRemboursement("100 %");
        assertThat(tauxderemboursement.get().getId()).isEqualTo("100 %");
    }

    */
}
