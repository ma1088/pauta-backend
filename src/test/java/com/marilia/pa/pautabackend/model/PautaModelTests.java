package com.marilia.pa.pautabackend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.jupiter.api.Test;


public class PautaModelTests {
    
    public Pauta buildMock(){
        Pauta pauta = new Pauta("Juca",LocalDateTime.now().atZone(ZoneId.of("-3")),"Pela Qualidade da Água","Todos os dias devemos trocar parte da água!",1);
        return pauta;
    }

    @Test
    public void setGetAutorTest(){
        Pauta p = buildMock();
        p.setAutor("Alana");
        assertEquals("Alana", p.getAutor());
    }

    @Test
    public void setGetTituloTest(){
        Pauta p = buildMock();
        p.setTitulo("Sifonagem de fundo");
        assertEquals("Sifonagem de fundo", p.getTitulo());
    }

    @Test
    public void setGetTextoTest(){
        Pauta p = buildMock();
        p.setTexto("Sifonar o fundo sem aspirar substrato");
        assertEquals("Sifonar o fundo sem aspirar substrato", p.getTexto());
    }

    @Test
    public void setGetQtdRespostasTest(){
        Pauta p = buildMock();
        p.setQtdRespostas(2);
        assertEquals(2, p.getQtdRespostas());
    }
}
