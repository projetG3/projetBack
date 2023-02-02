package com.gromed.demo.Controller;

import com.gromed.demo.controller.PresentationController;
import com.gromed.demo.model.*;
import com.gromed.demo.service.CompteService;
import com.gromed.demo.service.PresentationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PresentationControllerTest {
    @Mock
    private PresentationService presentationService;
    @InjectMocks
    private PresentationController controller;

    @Test
    public void testCheckUser() {
        Presentation presentation = new Presentation();
        presentation.setId(1L);

        when(presentationService.getPresentation(1L)).thenReturn(Optional.of(presentation));

        ResponseEntity<Presentation> response = controller.getPresentation(presentation.getId());
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    public void testCheckUserErrorPresentation(){
        Presentation presentation = new Presentation();
        presentation.setId(1L);

        when(presentationService.getPresentation(2L)).thenReturn(Optional.of(presentation));
        try {
            controller.getPresentation(presentation.getId());
            fail("Exception");
        } catch (ResponseStatusException ex) {
            assertEquals("Aucune présentation n'existe avec ce code", ex.getReason());
        }
    }

    @Test
    public void testGetStock() {
        Presentation presentation = new Presentation();
        presentation.setId(1L);
        presentation.setQuantitedispo(1);

        when(presentationService.getPresentation(1L)).thenReturn(Optional.of(presentation));

        Integer response = controller.getStock(presentation.getId());
        assertEquals(presentation.getQuantitedispo(), response);

    }

    @Test
    public void testGetStockErrorPresentation(){
        Presentation presentation = new Presentation();
        presentation.setId(1L);
        presentation.setQuantitedispo(1);

        when(presentationService.getPresentation(2L)).thenReturn(Optional.of(presentation));
        try {
            controller.getStock(presentation.getId());
            fail("Exception");
        } catch (ResponseStatusException ex) {
            assertEquals("Aucune présentation n'existe avec ce code", ex.getReason());
        }
    }


}


