package com.marilia.pa.pautabackend.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.marilia.pa.pautabackend.dto.FiltroPautaDTO;
import com.marilia.pa.pautabackend.dto.PautaDTO;
import com.marilia.pa.pautabackend.service.PautaService;


@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
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
        log.info("Nova pauta de " + pauta.getPauta().getAutor() + ", " + pauta.getPauta().getTitulo());
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(service.savePauta(
                            pauta.getPauta(),
                            pauta.getRespostas()));
    }

    @GetMapping(consumes = "application/json",
                produces = "application/json",
                value = "listar")
    public ResponseEntity<List<PautaDTO>> listarPautas(@RequestBody FiltroPautaDTO filtro){
        log.info("Listar pautas de " + filtro.getAutorLike() + 
                 ", entituladas " + filtro.getTituloLike() + 
                 ", com texto " + filtro.getTextoLike() + 
                 ", criadas entre " + filtro.getCriadoApos() + 
                 " e " + filtro.getCriadoAntesDe());
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(service.getPautas(filtro));
    }
}
