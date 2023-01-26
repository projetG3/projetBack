package com.gromed.demo.Service;

import com.gromed.demo.model.Estrembourseea;
import com.gromed.demo.model.Presentation;
import com.gromed.demo.service.PresentationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PresentationServiceTest {

    @Autowired
    PresentationService presentationService;

    @Test
    void getPresentation(){
        Optional<Presentation> presentation = presentationService.getPresentation(Long.valueOf(2663360));
        List<Estrembourseea> estrembourseeas = presentation.get().getEstremboursea();
        estrembourseeas.forEach(s->System.out.println(s.getId()));
        assertThat(estrembourseeas).isNotNull();
    }
}
