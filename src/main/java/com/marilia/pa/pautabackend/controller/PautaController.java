package com.marilia.pa.pautabackend.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
        log.info(pauta.getPauta().getAutor());
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(service.savePauta(
                            pauta.getPauta(),
                            pauta.getRespostas()));
    }
}
