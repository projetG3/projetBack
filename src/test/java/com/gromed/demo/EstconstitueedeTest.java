package com.gromed.demo;

import com.gromed.demo.model.Estconstitueede;
import com.gromed.demo.repository.EstconstitueedeRepository;
import com.gromed.demo.service.EstconstitueedeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EstconstitueedeTest {

    @Autowired
    private EstconstitueedeRepository estconstitueedeRepository;

    @Test
    public void testRepo1() {
        final var commandeClass = Fixtures.createCommande();
        final var presentationClass = Fixtures.createPresentation();
        final var estconstitueede = Fixtures.createEstconstitueede(commandeClass, presentationClass);

        Estconstitueede pEstconstitueede = estconstitueedeRepository.findAll().get(0);
        assertThat(pEstconstitueede).isNotNull().isNotSameAs(estconstitueede);
        assertThat(pEstconstitueede.getId()).isEqualTo(pEstconstitueede.getId());
    }
}
