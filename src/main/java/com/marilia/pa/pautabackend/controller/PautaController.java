package com.marilia.pa.pautabackend.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marilia.pa.pautabackend.dto.PautaDTO;
import com.marilia.pa.pautabackend.service.PautaService;

@Controller
@RequestMapping("/")
public class PautaController {
    private final Logger log = Logger.getLogger(this.getClass().getName());
    
    @Autowired
    PautaService service;

    @PostMapping(
        consumes = "application/json",
        produces = "application/json",
        value = "criar"
    )
    public ResponseEntity<PautaDTO> criarPauta(@RequestBody PautaDTO pauta){
        String pautaStr = "{}";
        try{
            pautaStr = new ObjectMapper().writeValueAsString(pauta);
            log.info(pautaStr);
        } catch(JsonProcessingException e){
            log.severe("criarPauta: (" + pauta.getPauta().getTitulo() + ") impossível converter em JSON " + e.getMessage());
        }
        
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(service.savePauta(
                            pauta.getPauta(),
                            pauta.getRespostas()));
    }
}
