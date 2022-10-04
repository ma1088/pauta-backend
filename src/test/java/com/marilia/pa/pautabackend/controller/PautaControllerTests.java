package com.marilia.pa.pautabackend.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marilia.pa.pautabackend.dto.PautaDTO;
import com.marilia.pa.pautabackend.model.Pauta;
import com.marilia.pa.pautabackend.model.Resposta;
import com.marilia.pa.pautabackend.service.PautaService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(PautaController.class)
public class PautaControllerTests {
    @MockBean
    PautaService pautaService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void criarPautaTest() throws Exception{
        PautaDTO pauta = new PautaDTO(
            new Pauta(
                "Juca", 
                LocalDateTime.now().atZone(ZoneId.of("-3")), 
                "As Bolinhas", 
                "Devem ser fornecidas duas vezes ao dia", 
                1), 
            Arrays.asList(
                new Resposta[] {
                    new Resposta(0L,"sim"),
                    new Resposta(0L,"não")
                } 
            ));

        when(pautaService.savePauta(any(Pauta.class), any(List.class)))
            .thenReturn(pauta);

        mockMvc.perform(MockMvcRequestBuilders.post("/pauta/criar")
                            .content(asJsonString(pauta))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON)
                        )
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pauta.autor", Matchers.is("Juca")));
    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper()
                .findAndRegisterModules()
                .writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
