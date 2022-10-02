package com.marilia.pa.pautabackend.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.jupiter.api.Test;

public class FiltroPautaDTOTests {

    public FiltroPautaDTO buildMock(){
        FiltroPautaDTO filtro = new FiltroPautaDTO();
        return filtro;
    }

    @Test
    public void getAndSetCriadoAntesDeTest(){
        //dado
        FiltroPautaDTO filtro = buildMock();

        //quando
        filtro.setCriadoAntesDe(ZonedDateTime.of(2022, 9, 01, 23, 0, 45, 1234, ZoneId.of("-3")));

        //então
        assertEquals(ZonedDateTime.of(2022, 9, 01, 23, 0, 45, 1234, ZoneId.of("-3")), filtro.getCriadoAntesDe());
    }

    @Test
    public void getAndSetCriadoAposTest(){
        //dado
        FiltroPautaDTO filtro = buildMock();

        //quando
        filtro.setCriadoApos(ZonedDateTime.of(2022, 9, 01, 23, 0, 45, 1234, ZoneId.of("-3")));

        //então
        assertEquals(ZonedDateTime.of(2022, 9, 01, 23, 0, 45, 1234, ZoneId.of("-3")), filtro.getCriadoApos());
    }

    @Test
    public void getSetAutorLike(){
        //dado
        FiltroPautaDTO filtro = buildMock();

        //quando
        filtro.setAutorLike("Ju");

        //então
        assertEquals("Ju", filtro.getAutorLike());
    }

    @Test
    public void getSetTituloLike(){
        //dado
        FiltroPautaDTO filtro = buildMock();

        //quando
        filtro.setTituloLike("água");

        //entao
        assertEquals("água", filtro.getTituloLike());
    }

    @Test
    public void getSetTextoLike(){
        //dado
        FiltroPautaDTO filtro = buildMock();

        //quando
        filtro.setTextoLike("água");

        //entao
        assertEquals("água", filtro.getTextoLike());
    }
}
