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
    public void setGetIdPergunta(){
        Resposta resp = buildMock();
        resp.setIdPergunta(2L);
        assertEquals(2, resp.getIdPergunta());
    }

}
