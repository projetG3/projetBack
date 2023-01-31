package com.gromed.demo.Service;

import com.gromed.demo.model.Conditionsmedicamenteuse;
import com.gromed.demo.service.ConditionsmedicamenteuseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ConditionsmedicamenteuseServiceTest {

    @Autowired
    ConditionsmedicamenteuseService conditionsmedicamenteuseService;

    @Test
    void getConditionsmedicamenteuse(){
        Conditionsmedicamenteuse conditionsmedicamenteuse = conditionsmedicamenteuseService.getConditionsmedicamenteuse("pour toute antériorité de traitement supérieur à 1 an :").orElseThrow();
        assertThat(conditionsmedicamenteuse.getId()).isEqualTo("pour toute antériorité de traitement supérieur à 1 an :");
    }
}
