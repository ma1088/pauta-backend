package com.marilia.pa.pautabackend.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.marilia.pa.pautabackend.model.Pauta;
import com.marilia.pa.pautabackend.model.Resposta;

public class PautaDtoTests {
    public PautaDTO buildMock(){
        PautaDTO PautaDto = new PautaDTO(new Pauta(), new ArrayList<Resposta>());
        return PautaDto;
    }

    @Test
    public void getSetPautaTest(){
        //dado
        PautaDTO pDto = buildMock();
        Pauta pauta = new Pauta("Juca", ZonedDateTime.now(), "Filtragem decente", "Defina um filtro decente", 1);

        //quando
        pDto.setPauta(pauta);

        //entao
        assertEquals(pauta, pDto.getPauta());
    }

    @Test
    public void getSetRespostasTest(){
        //dado
        PautaDTO pDto = buildMock();
        Resposta[] respostas = new Resposta[]{
            new Resposta(0L, "Sim"), 
            new Resposta(0L, "Não")
        };

        //quando
        pDto.setRespostas(new ArrayList<Resposta>(Arrays.asList(respostas)));

        //entao
        Resposta[] respostasToAssert = pDto.getRespostas().toArray(new Resposta[0]);
        assertEquals(respostas.length, respostasToAssert.length);
        for (int i = 0; i < respostas.length; i++){
            assertEquals(i + "-" + respostas[i], i + "-" + respostasToAssert[i]);
        }
        
    }
}
