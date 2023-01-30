package com.gromed.demo.Service;

import com.gromed.demo.model.Estlivree;
import com.gromed.demo.service.EstlivreeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EstlivreeServiceTest {

    @Autowired
    private EstlivreeService estlivreeService;

    @Test
    public void createEstlivree(){
        Estlivree estlivree = new Estlivree();
        estlivree.setIdcommande(Long.valueOf(1));
        estlivree.setCodecip7(Long.valueOf(3020232));
        estlivree.setStatus("envoyer");
        estlivree.setDateenvoi(LocalDate.now());
        estlivree.setQuantite(Long.valueOf(1));
        estlivreeService.saveEstlivree(estlivree);
    }
}
