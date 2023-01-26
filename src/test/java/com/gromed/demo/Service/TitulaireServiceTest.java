package com.gromed.demo.Service;

import com.gromed.demo.model.Titulaire;
import com.gromed.demo.service.TitulaireService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TitulaireServiceTest {

    @Autowired
    TitulaireService titulaireService;

    @Test
    void addTitulaire() throws SQLException {
        Titulaire test = new Titulaire();
        test.setId("test");
        titulaireService.saveTitulaire(test);
        assertThat(titulaireService.getTitulaire("test").get().getId()).isEqualTo("test");
        System.out.println("ADD TITULAIRE OK");
    }

}
