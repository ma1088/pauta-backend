package com.marilia.pa.pautabackend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RespostaModelTests {
    
    public Resposta buildMock(){
        Resposta r = new Resposta(1L,"sim");
        return r;
    }

    @Test
    public void setGetResposta(){
        Resposta resp = buildMock();
        resp.setTexto("não");
        assertEquals("não", resp.getTexto());
    }

    @Test
    public void setGetIdPauta(){
        Resposta resp = buildMock();
        resp.setIdPauta(2L);
        assertEquals(2, resp.getIdPauta());
    }

}
