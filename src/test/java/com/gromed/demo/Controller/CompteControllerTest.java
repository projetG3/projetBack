package com.gromed.demo.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gromed.demo.controller.CompteController;
import com.gromed.demo.model.Compte;
import com.gromed.demo.model.Utilisateur;
import com.gromed.demo.service.CompteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CompteController.class)
public class CompteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CompteService compteService;

    @Test
    public void testCheckUser() throws Exception {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(Long.valueOf(1));
        utilisateur.setPassword("password");
        Compte compte = new Compte();
        compte.setId(Long.valueOf(1));
        compte.setMotDePasse("password");
        when(compteService.getCompte(Long.valueOf(1))).thenReturn(Optional.of(compte));

        mockMvc.perform(post("/compte/auth")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(utilisateur)))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.id").value("id"))
                .andExpect((ResultMatcher) jsonPath("$.motDePasse").value("password"));
    }
}

